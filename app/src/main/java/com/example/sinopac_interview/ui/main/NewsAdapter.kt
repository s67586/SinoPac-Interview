package com.example.sinopac_interview.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sinopac_interview.R
import com.example.sinopac_interview.model.ResponseNewsListModel

class NewsAdapter : PagingDataAdapter<ResponseNewsListModel.Filtered, NewsAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ResponseNewsListModel.Filtered>() {
            override fun areItemsTheSame(oldItem: ResponseNewsListModel.Filtered, newItem: ResponseNewsListModel.Filtered): Boolean {
                return oldItem.mId == newItem.mId
            }

            override fun areContentsTheSame(oldItem: ResponseNewsListModel.Filtered, newItem: ResponseNewsListModel.Filtered): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mDate: TextView = itemView.findViewById(R.id.tv_news_adapter_date)
        val mTitle: TextView = itemView.findViewById(R.id.tv_news_adapter_title)
        val mImage: ImageView = itemView.findViewById(R.id.iv_news_adapter_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mModel = getItem(position)
        if (mModel != null) {
            holder.mDate.text = mModel.mPubDate
            holder.mTitle.text = mModel.mTitle
        }
    }

}