package com.example.sinopac_interview.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.sinopac_interview.model.ResponseNewsListModel
import com.example.sinopac_interview.ui.main.NewsRepository
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {
    fun getPagingData(): Flow<PagingData<ResponseNewsListModel.Filtered>> {
        return NewsRepository.getPagingData().cachedIn(viewModelScope)
    }
}