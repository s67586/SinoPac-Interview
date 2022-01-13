package com.example.sinopac_interview.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/****************************************************
 * Author: alanlai
 * Create Date: 5/3/21
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

fun String.convertTimeFormat():String {
   val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").apply {
        timeZone = TimeZone.getTimeZone("GMT+8")
    }.parse(this)
    return SimpleDateFormat("yyyy-MM-dd HH:mm").format(date ?: Date(System.currentTimeMillis()))
}

