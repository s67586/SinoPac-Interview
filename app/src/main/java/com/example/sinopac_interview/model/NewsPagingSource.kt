package com.example.sinopac_interview.model

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
            val repoResponse = Client.apiService.getNewsList(page,pageSize)
            val repoItems = repoResponse.mData?.mFiltered ?: emptyList()
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (repoItems.isNotEmpty()) page + 1 else null

            ALog.e("wekoqje = ${repoItems}")
            LoadResult.Page(repoItems, prevKey, nextKey)
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResponseNewsListModel.Filtered>): Int? = null

}