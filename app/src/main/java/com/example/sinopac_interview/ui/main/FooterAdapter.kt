package com.example.sinopac_interview.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sinopac_interview.R

/****************************************************
 * Author: alanlai
 * Create Date: 2022/1/13
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

class FooterAdapter(val onRetry: () -> Unit) : LoadStateAdapter<FooterAdapter.ViewHolder>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.adapter_footer_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.progressBar.isVisible = loadState is LoadState.Loading
        holder.retryButton.isVisible = loadState is LoadState.Error
        holder.retryButton.setOnClickListener {
            onRetry.invoke()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val progressBar: ProgressBar = itemView.findViewById(R.id.pb_adapter_footer_progressBar)
        val retryButton: Button = itemView.findViewById(R.id.bn_adapter_footer_retry)
    }
}