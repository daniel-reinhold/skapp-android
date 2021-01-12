package com.skapp.data.retrofit.models

import com.google.gson.annotations.SerializedName

data class Sheet(
    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("user_id")
    var userId: Int
)