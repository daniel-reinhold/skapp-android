package com.skapp.data.retrofit.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("display_name")
    val displayName: String,

    @SerializedName("email")
    val email: String
)