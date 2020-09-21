package com.augusto.network.movies

import com.augusto.network.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesClient {

    internal const val apiDataFormat = "yyyy-MM-dd'T'HH:mm:ss"
    val gsonDefault = GsonBuilder()
        .setDateFormat(apiDataFormat)
        .create()

    fun <S> getClient(url: String, api: Class<S>): S {
        val client = OkHttpClient.Builder()
            .addLogInterceptor()

        return Retrofit.Builder()
            .baseUrl(url)
            .client(client.build())
            .addConverterFactory(
                GsonConverterFactory.create(gsonDefault)
            )
            .build()
            .create(api)
    }
}

fun OkHttpClient.Builder.addLogInterceptor(): OkHttpClient.Builder {
    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        addNetworkInterceptor(logging)
    }
    return this
}