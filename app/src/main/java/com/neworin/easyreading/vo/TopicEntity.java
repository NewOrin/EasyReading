package com.neworin.easyreading.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * author : ZhangFubin
 * time   : 2017/12/23
 * desc   :
 */
public class TopicEntity{

    public List<Topic> data;
    public int pageSize;
    public int totalItems;
    public int totalPages;

    public List<Topic> getData() {
        return data;
    }

    public void setData(List<Topic> data) {
        this.data = data;
    }

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
    public class Topic {
        public String id;
        public String title;
        public String summary;
        public ArrayList<News> newsArray;
        public ArrayList<News> weiboArray;
        public ArrayList<News> wechatArray;
        public ArrayList<News> relatedTopicArray;
        public String publishUserId;
        public String order;
        public String publishDate;
        public String createdAt;
        public String updatedAt;

    }
    public class News {
        public String id;
        public String url;
        public String title;
        public String groupId;
        public String siteName;
        public String mobileUrl;
        public String authorName;
        public String duplicateId;
        public String publishDate;
    }
}