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

    companion object ApiFactory{
        private var api: AuthApi? = null
        private val gson = GsonBuilder().setLenient().create()

        fun getInstance(): AuthApi {
            if (api == null) {

                val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(OkHttpClient.Builder().also { client ->
                        if (BuildConfig.DEBUG) {
                            val logging = HttpLoggingInterceptor()
                            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                            client.addInterceptor(logging)
                        }
                    }.build())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()

                api = retrofit.create(AuthApi::class.java)
            }

            return api as AuthApi
        }
    }

}