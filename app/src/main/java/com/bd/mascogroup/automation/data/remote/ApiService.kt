package com.bd.mascogroup.automation.data.remote


import com.bd.mascogroup.automation.data.remote.domainModel.LoginPostData
import com.bd.mascogroup.automation.data.remote.domainModel.LoginResponse
import com.bd.mascogroup.automation.data.remote.domainModel.UserModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {
    @GET("/users/2")
    fun getUserModel(): Single<UserModel>

    @Headers("Content-Type: application/json")
    @POST("Deliveryman/login")
    fun doLogin(
            //@Query("Authorization") authorizationKey: String, // authentication header
            @Body loginPostData: LoginPostData): Observable<LoginResponse>
}