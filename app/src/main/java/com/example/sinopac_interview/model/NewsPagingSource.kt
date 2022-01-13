package com.example.sinopac_interview.model

import android.accounts.NetworkErrorException
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.sinopac_interview.base.ALog
import com.example.sinopac_interview.network.BaseResponse
import com.example.sinopac_interview.network.Client

class NewsPagingSource() :
    PagingSource<Int, ResponseNewsListModel.Filtered>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseNewsListModel.Filtered> {
        return try {
            val page = params.key ?: 1 // set page 1 as default
            val pageSize = params.loadSize

            when(val newsData = Client.safeApiCall { Client.apiService.getNewsList(page,pageSize) }){
                is BaseResponse.Success->{
                    ALog.e("Success")
                    val repoResponse = newsData.data.mData
                    val repoItems =  repoResponse?.mFiltered
                    val prevKey = if (page > 1) page - 1 else null
                    val nextKey = if (repoItems?.isNotEmpty() == true) page + 1 else null
                    LoadResult.Page(repoItems ?: emptyList(), prevKey, nextKey)
                }
                else -> {
                    ALog.e("Error")
                    LoadResult.Error(NetworkErrorException())
                }
            }
        } catch (e: Exception) {
            ALog.e("Exception")
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResponseNewsListModel.Filtered>): Int? = null

}