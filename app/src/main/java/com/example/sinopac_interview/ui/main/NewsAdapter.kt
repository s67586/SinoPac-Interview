package com.example.sinopac_interview.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.sinopac_interview.R
import com.example.sinopac_interview.base.ALog
import com.example.sinopac_interview.model.ResponseNewsListModel
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter :
    PagingDataAdapter<ResponseNewsListModel.Filtered, NewsAdapter.ViewHolder>(COMPARATOR) {
    private lateinit var mContext: Context

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ResponseNewsListModel.Filtered>() {
            override fun areItemsTheSame(
                oldItem: ResponseNewsListModel.Filtered,
                newItem: ResponseNewsListModel.Filtered
            ): Boolean {
                return oldItem.mId == newItem.mId
            }

            override fun areContentsTheSame(
                oldItem: ResponseNewsListModel.Filtered,
                newItem: ResponseNewsListModel.Filtered
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mModel = getItem(position)
        mModel?.let { model ->
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").apply {
                timeZone = TimeZone.getTimeZone("GMT+8")
            }.parse(model.mPubDate)

            holder.mDate.text = SimpleDateFormat("yyyy-MM-dd HH:mm").format(date?: Date(System.currentTimeMillis()))
            holder.mTitle.text = model.mTitle

            Glide.with(mContext)
                .load(if (model.mThumbs != null) mModel.mThumbs?.get(0)?.mUrl else "")
                .placeholder(R.drawable.shape_layout_8_radius_ccced5)
                .fallback(ContextCompat.getDrawable(
                        mContext,
                        R.drawable.shape_layout_8_radius_ccced5))
                .transform(CenterCrop(), RoundedCorners(25))
                .into(holder.mImage)

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mDate: TextView = itemView.findViewById(R.id.tv_news_adapter_date)
        val mTitle: TextView = itemView.findViewById(R.id.tv_news_adapter_title)
        val mImage: ImageView = itemView.findViewById(R.id.iv_news_adapter_title)
    }


}