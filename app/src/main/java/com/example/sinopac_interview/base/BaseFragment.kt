package com.example.sinopac_interview.base

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


/****************************************************
 * Author: AlanLai
 * Create Date: 2020/7/27
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract val mBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    abstract fun initConfiguration()

    abstract fun initListener()

    abstract fun observeLiveData()

    private var _binding: ViewBinding? = null

    @Suppress("UNCHECKED_CAST")
    protected val mBinding: VB
        get() = _binding as VB

    @SuppressLint("RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = mBindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initConfiguration()
        initListener()
        observeLiveData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}