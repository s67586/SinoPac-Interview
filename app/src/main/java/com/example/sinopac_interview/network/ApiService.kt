package com.example.sinopac_interview.network

import com.example.sinopac_interview.model.BaseResult
import com.example.sinopac_interview.model.ResponseNewsListModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    //取得新聞
    @GET("api/news")
    suspend fun getNewsList(): Response<BaseResult<ResponseNewsListModel>>
}

