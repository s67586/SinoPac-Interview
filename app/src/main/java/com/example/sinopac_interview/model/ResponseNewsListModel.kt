package com.example.sinopac_interview.model
import com.google.gson.annotations.SerializedName


data class ResponseNewsListModel(
    @SerializedName("filtered")
    val mFiltered: List<Filtered> = emptyList(),
    @SerializedName("page")
    val mPage: Int,
    @SerializedName("total")
    val mTotal: Int
) {
    data class Filtered(
        @SerializedName("category")
        val mCategory: String,
        @SerializedName("content")
        val mContent: String,
        @SerializedName("creator")
        val mCreator: String,
        @SerializedName("_id")
        val mId: String,
        @SerializedName("keywords")
        val mKeywords: List<String>,
        @SerializedName("link")
        val mLink: String,
        @SerializedName("provider")
        val mProvider: String,
        @SerializedName("pubDate")
        val mPubDate: String,
        @SerializedName("rel")
        val mRel: Any,
        @SerializedName("stockList")
        val mStockList: List<Stock>,
        @SerializedName("summary")
        val mSummary: String,
        @SerializedName("thumbs")
        val mThumbs: List<Thumb>,
        @SerializedName("title")
        val mTitle: String
    ) {
        data class Stock(
            @SerializedName("code")
            val mCode: String,
            @SerializedName("name")
            val mName: String
        )

        data class Thumb(
            @SerializedName("caption")
            val mCaption: String,
            @SerializedName("height")
            val mHeight: Int,
            @SerializedName("url")
            val mUrl: String,
            @SerializedName("width")
            val mWidth: Int
        )
    }
}