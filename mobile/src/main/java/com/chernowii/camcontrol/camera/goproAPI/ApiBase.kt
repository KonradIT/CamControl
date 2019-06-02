package com.chernowii.camcontrol.camera.goproAPI

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBase {


    val mainClient: Retrofit
        get() {
            var GoProMainAPI: Retrofit? = null


            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            GoProMainAPI = Retrofit.Builder()
                    .baseUrl("http://10.5.5.9")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            return GoProMainAPI
        }

    val mediaClient: Retrofit
        get() {
            var GoProMediaAPI: Retrofit? = null
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            GoProMediaAPI = Retrofit.Builder()
                    .baseUrl("http://10.5.5.9:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            return GoProMediaAPI
        }


    object Info {
        val VendorSite = "http://gopro.com"
    }
}
