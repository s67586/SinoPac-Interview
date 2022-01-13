package com.example.sinopac_interview.ui

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.sinopac_interview.base.BaseActivity
import com.example.sinopac_interview.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val mViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override val mBindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun initConfiguration() {
    }

    override fun initListener() {
    }

    override fun observeLiveData() {
    }
}