package com.example.sinopac_interview.ui.main

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.sinopac_interview.model.NewsPagingSource
import com.example.sinopac_interview.model.ResponseNewsListModel
import kotlinx.coroutines.flow.Flow

object NewsRepository {

    private const val PAGE_SIZE = 50

    fun getPagingData(): Flow<PagingData<ResponseNewsListModel.Filtered>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = { NewsPagingSource() }
        ).flow
    }

}