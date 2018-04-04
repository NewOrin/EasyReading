package com.neworin.easyreading.vo

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
class PageResult<T> {
    var pageSize = 0
    var totalItems = 0
    var totalPages = 0
    var data: List<T>? = null
}