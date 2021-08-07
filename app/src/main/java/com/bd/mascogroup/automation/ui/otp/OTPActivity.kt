package com.bd.mascogroup.automation.ui.otp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import com.bd.mascogroup.automation.R
import com.bd.mascogroup.automation.databinding.ActivityOtpBinding
import com.bd.mascogroup.automation.ui.base.BaseActivity
import javax.inject.Inject

class OTPActivity : BaseActivity<ActivityOtpBinding, OTPViewModel>(), IOTPNavigator {


    @Inject
    override lateinit var viewModel: OTPViewModel

    private var mActivityOtpBinding: ActivityOtpBinding? = null

    @Inject
    lateinit var mOTPViewModel: OTPViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int

        get() = R.layout.activity_otp



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityOtpBinding = viewDataBinding
        viewModel.navigator = this
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, OTPActivity::class.java)
        }
    }
}