package com.example.sinopac_interview.ui

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.sinopac_interview.base.ALog
import com.example.sinopac_interview.base.BaseActivity
import com.example.sinopac_interview.databinding.ActivityMainBinding
import com.example.sinopac_interview.network.BaseResponse
import com.example.sinopac_interview.network.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val mViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override val mBindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun initConfiguration() {
        lifecycleScope.launch(Dispatchers.IO) {
            mViewModel.getPagingData().collect {pagingData ->
                ALog.e("jsaiedwe = ${pagingData.toString()}")
            }
        }

//        lifecycleScope.launch(Dispatchers.IO){
//            when(val newsData = Client.safeApiCall { Client.apiService.getNewsList(3) }){
//                is BaseResponse.Success->{
//                    ALog.e("awjieje = ${newsData.data.mData}")
//                }
//            }
//        }
    }

    override fun initListener() {
    }

    override fun observeLiveData() {
    }
}