package com.example.sinopac_interview.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sinopac_interview.base.BaseFragment
import com.example.sinopac_interview.databinding.FragmentDetailBinding

/****************************************************
 * Author: alanlai
 * Create Date: 3/18/21
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override val mBindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentDetailBinding = FragmentDetailBinding::inflate

    override fun initConfiguration() {
    }

    override fun initListener() {
    }

    override fun observeLiveData() {
    }
}