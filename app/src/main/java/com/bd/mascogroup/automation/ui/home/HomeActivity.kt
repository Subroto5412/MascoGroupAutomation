package com.bd.mascogroup.automation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import com.bd.mascogroup.automation.R
import com.bd.mascogroup.automation.databinding.ActivityHomeBinding
import com.bd.mascogroup.automation.ui.base.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), IHomeNavigator {


    @Inject
    override lateinit var viewModel: HomeViewModel

    private var mActivityHomeBinding: ActivityHomeBinding? = null

    @Inject
    lateinit var mHomeViewModel: HomeViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int

        get() = R.layout.activity_home



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityHomeBinding = viewDataBinding
        viewModel.navigator = this
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}