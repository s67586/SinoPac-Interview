package com.example.sinopac_interview.ui

import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.sinopac_interview.base.ALog
import com.example.sinopac_interview.base.BaseActivity
import com.example.sinopac_interview.databinding.ActivityMainBinding
import com.example.sinopac_interview.network.BaseResponse
import com.example.sinopac_interview.network.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val mBindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun initConfiguration() {
        lifecycleScope.launch(Dispatchers.IO){
            when(val newsData = Client.safeApiCall { Client.apiService.getNewsList() }){
                is BaseResponse.Success->{
                   ALog.e("awjieje = ${newsData.data.mData}")
                }
            }
        }

    }

    override fun initListener() {
    }

    override fun observeLiveData() {
    }
}