package com.bd.mascogroup.automation.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.databinding.library.baseAdapters.BR
import com.bd.mascogroup.automation.R
import com.bd.mascogroup.automation.databinding.ActivityLoginBinding
import com.bd.mascogroup.automation.ui.base.BaseActivity
import com.bd.mascogroup.automation.utils.AppUtils
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import java.net.URL
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), ILoginNavigator,
        HasAndroidInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    override lateinit var viewModel: LoginViewModel
        internal set
    private var mActivityLoginBinding: ActivityLoginBinding? = null

    @Inject
    lateinit var mLoginViewModel: LoginViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int

        get() = R.layout.activity_login


    override fun login() {

        val userId = mActivityLoginBinding!!.activityLoginIdTiet.text!!.toString()
        val password = mActivityLoginBinding!!.activityLoginPasswordTiet.text!!.toString()

        if (viewModel.isUserIdAndPasswordValid(userId, password)) {
       //     hideKeyboard()
            //viewModel.login(userId, password, this)
          //  showMessage(getString(R.string.invalid_email_password), AppUtils.MessageType.ERROR)
        } else {
            //Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
         //   showMessage(getString(R.string.invalid_email_password), AppUtils.MessageType.ERROR)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLoginBinding = viewDataBinding
        viewModel.navigator = this
        setup()
    }

    fun setup() {

        mActivityLoginBinding!!.activityLoginIdTiet.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                mActivityLoginBinding!!.activityLoginMainActv.isEnabled =
                        viewModel.isUserIdAndPasswordValid(
                                mActivityLoginBinding!!.activityLoginIdTiet.text!!.toString(),
                                mActivityLoginBinding!!.activityLoginPasswordTiet.text!!.toString()
                        )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        mActivityLoginBinding!!.activityLoginPasswordTiet.addTextChangedListener(object :
                TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                mActivityLoginBinding!!.activityLoginMainActv.isEnabled =
                        viewModel.isUserIdAndPasswordValid(
                                mActivityLoginBinding!!.activityLoginIdTiet.text!!.toString(),
                                mActivityLoginBinding!!.activityLoginPasswordTiet.text!!.toString()
                        )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    override fun openOrderListActivity() {
    /*    val intent = OrderListActivity.newIntent(this@LoginActivity)
        startActivity(intent)
        finish()*/
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
