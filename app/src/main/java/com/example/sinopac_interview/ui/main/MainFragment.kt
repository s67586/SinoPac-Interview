package com.example.sinopac_interview.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sinopac_interview.base.ALog
import com.example.sinopac_interview.base.BaseFragment
import com.example.sinopac_interview.databinding.FragmentMainBinding
import com.example.sinopac_interview.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/****************************************************
 * Author: alanlai
 * Create Date: 3/18/21
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

class MainFragment : BaseFragment<FragmentMainBinding>() {
    private val mViewModel by activityViewModels<MainViewModel>()
    private val mAdapter by lazy {
        NewsAdapter()
    }
    override val mBindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentMainBinding = FragmentMainBinding::inflate

    override fun initConfiguration() {
        mBinding.rvMainFragmentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mBinding.rvMainFragmentRecyclerView.adapter = mAdapter
    }

    override fun initListener() {
    }

    override fun observeLiveData() {
        lifecycleScope.launch(Dispatchers.IO) {
            mViewModel.getPagingData().collect {pagingData ->
                mAdapter.submitData(pagingData)
            }
        }
    }
}