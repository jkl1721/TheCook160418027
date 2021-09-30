package com.ubaya.thecook160418027.Model

import com.google.gson.annotations.SerializedName

data class Resep(
    val id:String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("bahan")
    val bahan:String?,
    @SerializedName("langkah")
    val langkah:String?
)