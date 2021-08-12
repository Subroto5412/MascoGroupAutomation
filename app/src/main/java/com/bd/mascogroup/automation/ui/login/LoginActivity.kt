package com.bd.mascogroup.automation.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.library.baseAdapters.BR
import com.bd.mascogroup.automation.R
import com.bd.mascogroup.automation.databinding.ActivityLoginBinding
import com.bd.mascogroup.automation.ui.base.BaseActivity
import com.bd.mascogroup.automation.ui.home.HomeActivity
import com.bd.mascogroup.automation.ui.production_management.ProductionManagementActivity
import com.bd.mascogroup.automation.ui.signup.SignupActivity
import com.bd.mascogroup.automation.utils.AppUtils
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_login.*
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



    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLoginBinding = viewDataBinding
        viewModel.navigator = this
        activity_login_signup_tv.setOnClickListener {
            val intent = SignupActivity.newIntent(this@LoginActivity)
            startActivity(intent)
        }

        signInBtn.setOnClickListener {
           /* val intent = ProductionManagementActivity.newIntent(this@LoginActivity)
            startActivity(intent)*/
            openSignupActivity()
        }
        activity_login_forgot_password_tv.setOnClickListener {
            val intent = SignupActivity.newIntent(this@LoginActivity)
            startActivity(intent)
        }
        setup()
    }


    fun setup() {

        activity_login_user_id_et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
               if (!s.toString().equals("")){
                   activity_login_user_id_et.setBackgroundResource(R.drawable.input_field_white_bg)
                   activity_login_logo_im.isGone = true
                   activity_login_user_cl.isGone = false
                   activity_login_user_name_tv.isGone = false
                   activity_login_unit_name_tv.isGone = false
               }else{
                   activity_login_user_id_et.setBackgroundResource(R.drawable.input_filed_bg)
                   activity_login_logo_im.isGone = false
                   activity_login_user_cl.isGone = true
                   activity_login_user_name_tv.isGone = true
                   activity_login_unit_name_tv.isGone = true
               }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        activity_login_password_et.addTextChangedListener(object :
                TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!s.toString().equals("")){
                    activity_login_password_et.setBackgroundResource(R.drawable.input_field_white_bg)
                    activity_login_signin_btn.isGone = false
                    activity_login_signin_btn_hide.isGone = true
                }else{
                    activity_login_password_et.setBackgroundResource(R.drawable.input_filed_bg)
                    activity_login_signin_btn_hide.isGone = false
                    activity_login_signin_btn.isGone = true
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

    }


     fun openSignupActivity() {
        val intent = HomeActivity.newIntent(this@LoginActivity)
        startActivity(intent)
//        finish()
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
