package com.bd.mascogroup.automation.ui.login

import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.bd.mascogroup.automation.data.IDataManager
import com.bd.mascogroup.automation.data.remote.ApiServiceCalling
import com.bd.mascogroup.automation.data.remote.domainModel.LoginPostData
import com.bd.mascogroup.automation.ui.base.BaseViewModel
import com.bd.mascogroup.automation.utils.UtilMethods
import com.bd.mascogroup.automation.utils.rx.ISchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class LoginViewModel @Inject constructor(
        dataManager: IDataManager,
        ISchedulerProvider: ISchedulerProvider
): BaseViewModel<ILoginNavigator>(dataManager, ISchedulerProvider) {

    /*fun login(loginId: String, password: String, context: Context) {

        if(UtilMethods.isConnectedToInternet(context)){
            UtilMethods.showLoading(context)
            val observable = ApiServiceCalling.loginApiCall().doLogin(LoginPostData(loginId, password))

            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ loginResponse ->
                    if(loginResponse.response=="true")
                    {
                        dataManager.deliveryManId  = loginResponse.data.delivery_man_data_id
                        navigator?.openOrderListActivity()
                    }
                    UtilMethods.hideLoading()
                }, { error ->
                    UtilMethods.hideLoading()
                    UtilMethods.showLongToast(context, error.message.toString())
                }
                )
        }else{
            UtilMethods.showLongToast(context, "No Internet Connection!")
        }
    }*/

    fun isUserIdAndPasswordValid(userId: String, password: String): Boolean {
        // validate email and password
        if (TextUtils.isEmpty(userId)) {
            return false
        }
        return !TextUtils.isEmpty(password)
    }

    fun onServerLoginClick() {
        navigator?.login()
    }


}