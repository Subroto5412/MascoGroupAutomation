package com.bd.mascogroup.automation.data.remote.domainModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginPostData(
        @SerializedName("mobile1") var mobile1: String,
        @SerializedName("password") var password: String
)
