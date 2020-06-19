package com.rujirakongsomran.kt_retrofit2andrxjava.Retrofit

import com.rujirakongsomran.kt_retrofit2andrxjava.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface IMyAPI {
    @get:GET("posts")
    val posts:Observable<List<Post>>
}