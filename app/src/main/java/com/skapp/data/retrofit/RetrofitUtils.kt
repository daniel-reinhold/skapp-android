package com.skapp.data.retrofit

import com.skapp.data.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitUtils {

    companion object {

        fun<T> getRetrofit(api: Class<T>): T {
            return Retrofit.Builder()
                    .baseUrl("${BASE_URL}/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(api)
        }

    }

}