package com.example.sinopac_interview.network

import com.example.sinopac_interview.model.BaseResult
import com.example.sinopac_interview.model.ResponseNewsListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    //取得新聞
    @GET("api/news")
    suspend fun getNewsList(@Query("page") page: Int, @Query("limit") limit: Int = 50): Response<BaseResult<ResponseNewsListModel>>
}

