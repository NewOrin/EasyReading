package com.neworin.easyreading.utils

/**
 * author : ZhangFubin
 * time   : 2018/04/03
 * desc   :
 */

fun formatTime(text: String?): String {
    if (text?.isEmpty() != false) {
        return text ?: ""
    }
    try {
        val date = text.toDate("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val timestamp = date?.time!!
        val current = System.currentTimeMillis()
        val timeSpan = (current - timestamp) / 1000
        return TimeDescription(timeSpan).toString()
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return text
}

class TimeDescription(private val timeSpan: Long) {
    private val day: Int = (timeSpan / (60 * 60 * 24)).toInt()
    private val hour: Int = (timeSpan % (60 * 60 * 24) / (60 * 60)).toInt()
    private val minute: Int = (timeSpan % (60 * 60) / 60).toInt()

    override fun toString(): String {
        if (day > 0) {
            return "${day}天前"
        }
        if (hour > 0) {
            return "${hour}小时前"
        }
        if (minute > 0) {
            return "${minute}分钟前"
        }
        return "刚刚"
    }
}