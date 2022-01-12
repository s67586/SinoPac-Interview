package com.example.sinopac_interview.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sinopac_interview.base.BaseFragment
import com.example.sinopac_interview.databinding.FragmentMainBinding

/****************************************************
 * Author: alanlai
 * Create Date: 3/18/21
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val mBindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentMainBinding = FragmentMainBinding::inflate

    override fun initConfiguration() {
    }

    override fun initListener() {
    }

    override fun observeLiveData() {
    }
}