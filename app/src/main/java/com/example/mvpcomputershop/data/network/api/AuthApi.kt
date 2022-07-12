package com.example.mvpcomputershop.data.network.api

import com.example.mvpcomputershop.BuildConfig
import com.example.mvpcomputershop.data.network.model.request.LoginRequestApiModel
import com.example.mvpcomputershop.data.network.model.request.SignUpRequestApiModel
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/get_token")
    @Headers("Content-Type: application/json")
    fun login(
        @Body user: LoginRequestApiModel
    ) : Single<String>

    @POST("practice/shop/registration")
    @Headers("Content-Type: application/json")
    fun signUp(
        @Body user: SignUpRequestApiModel
    ) : Single<String>

}