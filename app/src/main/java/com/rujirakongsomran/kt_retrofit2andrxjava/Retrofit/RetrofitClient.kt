package com.rujirakongsomran.kt_retrofit2andrxjava.Retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var outInstance: Retrofit? = null
    val instance: Retrofit
        get() {
            if (outInstance == null) {
                outInstance = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return outInstance!!
        }
}