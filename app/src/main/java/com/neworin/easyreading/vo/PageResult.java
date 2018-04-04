package com.neworin.easyreading.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
public class PageResult<T> {
    @SerializedName("pageSize")
    private int pageSize;
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("totalPages")
    private int totalPages;
    @SerializedName("data")
    private List<T> data;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}