package com.example.sinopac_interview.network

import com.example.sinopac_interview.model.BaseResult

/****************************************************
 * Copyright (C) Alan Corporation. All rights reserved.
 *
 * Author: AlanLai
 * Create Date: 2020/6/4
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

sealed class BaseResponse<out T> {
    data class Success<out T>(val data: T) : BaseResponse<T>()
    data class Fail(val data: BaseResult<*>) : BaseResponse<Nothing>()
    data class Error(val exception: Exception) : BaseResponse<Nothing>()
}