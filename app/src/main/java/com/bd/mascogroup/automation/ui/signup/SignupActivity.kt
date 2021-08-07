package com.bd.mascogroup.automation.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import com.bd.mascogroup.automation.R
import com.bd.mascogroup.automation.databinding.ActivitySignupBinding
import com.bd.mascogroup.automation.ui.base.BaseActivity
import com.bd.mascogroup.automation.ui.otp.OTPActivity
import kotlinx.android.synthetic.main.activity_signup.*
import javax.inject.Inject

class SignupActivity : BaseActivity<ActivitySignupBinding, SignupViewModel>(), ISignupNavigator{


    @Inject
    override lateinit var viewModel: SignupViewModel

    private var mActivitySignupBinding: ActivitySignupBinding? = null

    @Inject
    lateinit var mSignupViewModel: SignupViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int

        get() = R.layout.activity_signup



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivitySignupBinding = viewDataBinding
        viewModel.navigator = this

        signInBtnmaterialCardView.setOnClickListener {
            openOtpActivity()
        }

    }

    fun openOtpActivity() {
        val intent = OTPActivity.newIntent(this@SignupActivity)
        startActivity(intent)
//        finish()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SignupActivity::class.java)
        }
    }
}