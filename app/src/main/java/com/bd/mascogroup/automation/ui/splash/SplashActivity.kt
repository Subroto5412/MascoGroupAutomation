package com.bd.mascogroup.automation.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.databinding.library.baseAdapters.BR
import com.bd.mascogroup.automation.R
import com.bd.mascogroup.automation.databinding.ActivitySplashBinding
import com.bd.mascogroup.automation.ui.base.BaseActivity
import com.bd.mascogroup.automation.ui.login.LoginActivity

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), ISplashNavigator,
        HasAndroidInjector {

    override val viewModel: SplashViewModel
        get() = mSplashViewModel

    @Inject
    lateinit var mSplashViewModel: SplashViewModel

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        Handler().postDelayed(
                {
                    openMainActivity()
                    finish()
                }, 3 * 1000)

    }

    override fun openMainActivity() {
        val intent = LoginActivity.newIntent(this@SplashActivity)
        startActivity(intent)
        finish()

     /*   val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)*/
    }

    //    override fun exitApplication() {
//        finish()
//    }
    override fun androidInjector(): AndroidInjector<Any>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }
}