package com.ubaya.thecook160418027.Model

import com.google.gson.annotations.SerializedName

data class User(
    val id:String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("username")
    val username:String?,
    @SerializedName("password")
    val password:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)