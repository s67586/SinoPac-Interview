package com.example.sinopac_interview.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.sinopac_interview.R
import com.example.sinopac_interview.base.BaseFragment
import com.example.sinopac_interview.databinding.FragmentDetailBinding
import com.example.sinopac_interview.ui.MainViewModel
import com.example.sinopac_interview.util.convertTimeFormat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/****************************************************
 * Author: alanlai
 * Create Date: 3/18/21
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    private val mViewModel by activityViewModels<MainViewModel>()
    override val mBindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentDetailBinding = FragmentDetailBinding::inflate

    override fun initConfiguration() {
    }

    override fun initListener() {
    }

    override fun observeLiveData() {
        mViewModel.mNewsDetailLiveData.observe(viewLifecycleOwner, Observer {model ->
            lifecycleScope.launch(Dispatchers.Main){
                mBinding.tvDetailFragmentProvider.text = model.mProvider
                mBinding.tvDetailFragmentDate.text = model.mPubDate.convertTimeFormat()
                mBinding.tvDetailFragmentTitle.text = model.mTitle

                Glide.with(requireContext())
                    .load(if (model.mThumbs != null) model.mThumbs[0].mUrl else "")
                    .placeholder(R.drawable.shape_layout_8_radius_ccced5)
                    .fallback(ContextCompat.getDrawable(requireContext(), R.drawable.shape_layout_8_radius_ccced5))
                    .transform(CenterCrop(), RoundedCorners(25))
                    .into(mBinding.ivDetailFragmentTitle)

                mBinding.tvDetailFragmentContent.text = model.mContent
            }
        })
    }
}