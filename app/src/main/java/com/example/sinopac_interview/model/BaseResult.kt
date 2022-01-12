package com.example.sinopac_interview.model

import com.google.gson.annotations.SerializedName


/****************************************************
 * Author: alanlai
 * Create Date: 5/28/21
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

open class BaseResult<T>(
    @SerializedName("code")
    val mCode: Int = -1,
    @SerializedName("data")
    val mData: T? = null,
    @SerializedName("msg")
    val mMsg: String = "",
    @SerializedName("token")
    val mToken: String = "",
    @SerializedName("paging")
    val mPaging: Paging? = null
)

data class Paging(
    @SerializedName("page")
    val mPage: Int,
    @SerializedName("size")
    val mSize: Int,
    @SerializedName("total_count")
    val mTotalCount: Int,
    @SerializedName("total_page")
    val mTotalPage: Int
)