package com.bd.mascogroup.automation.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.databinding.library.baseAdapters.BR
import com.bd.mascogroup.automation.R
import com.bd.mascogroup.automation.databinding.ActivitySplashBinding
import com.bd.mascogroup.automation.ui.base.BaseActivity
import com.bd.mascogroup.automation.ui.login.LoginActivity

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_splash.*
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
       /* Handler().postDelayed(
                {
                    openMainActivity()
                    finish()
                }, 3 * 1000)*/

        val animationZoom = AnimationUtils.loadAnimation(this, R.anim.zoom)
        activity_spalsh_down_logo_im2.startAnimation(animationZoom)



        /*if (density > 400) {
            textNameAnimationXXHDI()
        } else {
            when (density) {
                DisplayMetrics.DENSITY_LOW -> {
                    textNameAnimation()
                }
                DisplayMetrics.DENSITY_MEDIUM -> {
                    textNameAnimation()
                }
                DisplayMetrics.DENSITY_HIGH -> {
                    textNameAnimation()
                }
                DisplayMetrics.DENSITY_XHIGH -> {
                    textNameAnimation()
                }
                DisplayMetrics.DENSITY_XXHIGH -> {
                    textNameAnimationXXHDI()
                }
                DisplayMetrics.DENSITY_XXXHIGH -> {
                    textNameAnimationXXHDI()
                }
            }
        }*/

        Handler().postDelayed(
                {
                    val animationZoom1 = AnimationUtils.loadAnimation(this, R.anim.zoom)
                    activity_spalsh_down_logo_im2.startAnimation(animationZoom1)
                }, 1200)

        viewModel.navigator = this
        Handler().postDelayed({
            viewModel.startSeeding()
            finish()
        }, 2400)

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