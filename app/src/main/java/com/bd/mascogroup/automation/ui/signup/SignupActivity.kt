package com.bd.mascogroup.automation.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import com.bd.mascogroup.automation.R
import com.bd.mascogroup.automation.databinding.ActivitySignupBinding
import com.bd.mascogroup.automation.ui.base.BaseActivity
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
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SignupActivity::class.java)
        }
    }
}