package com.bd.mascogroup.automation.di.builder

import com.bd.mascogroup.automation.ui.login.LoginActivity
import com.bd.mascogroup.automation.ui.login.LoginActivityModule
import com.bd.mascogroup.automation.ui.signup.SignupActivity
import com.bd.mascogroup.automation.ui.signup.SignupActivityModule
import com.bd.mascogroup.automation.ui.splash.SplashActivity
import com.bd.mascogroup.automation.ui.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module(
        includes =
        [SplashActivityModule::class, LoginActivityModule::class, SignupActivityModule::class]
)



abstract class ActivityBuilder {

    @ContributesAndroidInjector(
            modules = [SplashActivityModule::class]
    )
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(
            modules = [LoginActivityModule::class]
    )
    internal abstract fun bindLoginActivity(): LoginActivity

 @ContributesAndroidInjector(
            modules = [SignupActivityModule::class]
    )
    internal abstract fun bindSignupActivity(): SignupActivity

    /* @ContributesAndroidInjector(
      modules = [OrderListDetailsActivityModule::class, OrderListDetailsAdapterModule::class]
  )
  internal abstract fun bindOrderListDetailsActivity(): OrderListDetailsActivity

  @ContributesAndroidInjector(
      modules = [OrderSubmitActivityModule::class]
  )
  internal abstract fun bindOrderSubmitActivity(): OrderSubmitActivity

  @ContributesAndroidInjector(
          modules = [ReturnProductActivityModule::class]
  )
  internal abstract fun bindReturnProductActivity(): ReturnProductActivity*/
}
