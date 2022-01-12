package com.example.sinopac_interview.ui

import android.view.LayoutInflater
import androidx.navigation.NavController
import com.example.sinopac_interview.base.BaseActivity
import com.example.sinopac_interview.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val mBindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun initConfiguration() {
    }

    override fun initListener() {
    }

    override fun observeLiveData() {
    }
}