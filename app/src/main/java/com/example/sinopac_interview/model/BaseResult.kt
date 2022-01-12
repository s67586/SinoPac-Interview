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
    @SerializedName("err")
    val mErr: Boolean = false,
    @SerializedName("data")
    val mData: T? = null,
    @SerializedName("statusMsg")
    val mStatusMsg: String = "",
    @SerializedName("statusCode")
    val mStatusCode: String = "",
)