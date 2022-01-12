package com.example.sinopac_interview.network

import android.widget.Toast
import com.example.sinopac_interview.model.BaseResult
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {

    val apiService: WrapperApiService

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MDFiYTVhODg1MGViMzRjNTg2ODg5Y2MiLCJtb2RlbCI6IkFwcERldmljZSIsImlhdCI6MTYxMjQyNTM0NywiZXhwIjoxNjI3OTc3MzQ3fQ.8ATkhNKUP_vCSCplIyfQV6Udd6kXE6mPXeudVIZUsXs")
                    .url(chain.request().url)
                    .build()

                chain.proceed(newRequest)
            })
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fintech.eastasia.cloudapp.azure.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        apiService = WrapperApiService(retrofit.create(ApiService::class.java))
    }

    suspend inline fun <reified T> safeApiCall(crossinline callFunction: suspend () -> Response<T>): BaseResponse<T> =
        withContext(Dispatchers.IO) {
            try {
                val response = callFunction.invoke()

                if (response.isSuccessful) {
                    if (response.body() == null) {
                        if (T::class.java.simpleName == Unit.javaClass.simpleName) {
                            BaseResponse.Success(response.body() as T)
                        } else {
                            BaseResponse.Error(IllegalArgumentException("content error"))
                        }
                    } else {
                        BaseResponse.Success(response.body()!!)
                    }
                } else if (response.code() == 400) {
                    val errorResult = Gson().fromJson(
                        response.errorBody()?.string(),
                        BaseResult::class.java)
                    BaseResponse.Fail(errorResult)
                } else {
                    BaseResponse.Error(HttpException(response))
                }
            } catch (e: Exception) {
                BaseResponse.Error(e)
            }
        }
}