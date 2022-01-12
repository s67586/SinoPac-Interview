package com.example.sinopac_interview.base

import android.annotation.SuppressLint
import android.graphics.PixelFormat
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewbinding.ViewBinding


/****************************************************
 * Author: AlanLai
 * Create Date: 2020/4/24
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: ViewBinding? = null
    abstract val mBindingInflater: (LayoutInflater) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val mBinding: VB
        get() = _binding as VB


    abstract fun initConfiguration()

    abstract fun initListener()

    abstract fun observeLiveData()

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = mBindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        window.setFormat(PixelFormat.TRANSLUCENT)
        initConfiguration()
        initListener()
        observeLiveData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
