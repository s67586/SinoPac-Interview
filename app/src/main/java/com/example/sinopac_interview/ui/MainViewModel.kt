package com.example.sinopac_interview.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.sinopac_interview.model.ResponseNewsListModel
import com.example.sinopac_interview.ui.main.NewsRepository
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {
    val mNewsDetailLiveData: LiveData<ResponseNewsListModel.Filtered> = MutableLiveData()

    fun getPagingData(): Flow<PagingData<ResponseNewsListModel.Filtered>> {
        return NewsRepository.getPagingData().cachedIn(viewModelScope)
    }

    fun setNewsDetailData(newsDetail: ResponseNewsListModel.Filtered) {
        (mNewsDetailLiveData as MutableLiveData).postValue(newsDetail)
    }
}