package com.example.sinopac_interview.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding

/****************************************************
 * Author: AlanLai
 * Create Date: 2020/5/13
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

abstract class BaseDialogFragment<VB : ViewBinding> : DialogFragment() {

    private var _binding: ViewBinding? = null
    abstract val mBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val mBinding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        _binding = mBindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            if (!isVisible) {
                manager.beginTransaction().remove(this).commit()
                super.show(manager, tag)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun dismiss() {
        if (dialog?.isShowing == true) {
            dialog?.dismiss()
        }
    }
}