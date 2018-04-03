package com.neworin.easyreading.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author : ZhangFubin
 * time   : 2017/12/23
 * desc   :
 */
public class TopicEntity {

    @SerializedName("pageSize")
    private int pageSize;
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("totalPages")
    private int totalPages;
    @SerializedName("data")
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("id")
        private String id;
        @SerializedName("createdAt")
        private String createdAt;
        @SerializedName("order")
        private int order;
        @SerializedName("publishDate")
        private String publishDate;
        @SerializedName("summary")
        private String summary;
        @SerializedName("title")
        private String title;
        @SerializedName("updatedAt")
        private String updatedAt;
        @SerializedName("timeline")
        private Object timeline;
        @SerializedName("extra")
        private ExtraBean extra;
        @SerializedName("newsArray")
        private List<NewsArrayBean> newsArray;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getTimeline() {
            return timeline;
        }

        public void setTimeline(Object timeline) {
            this.timeline = timeline;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public List<NewsArrayBean> getNewsArray() {
            return newsArray;
        }

        public void setNewsArray(List<NewsArrayBean> newsArray) {
            this.newsArray = newsArray;
        }

        public static class ExtraBean {
            @SerializedName("instantView")
            private boolean instantView;

            public boolean isInstantView() {
                return instantView;
            }

            public void setInstantView(boolean instantView) {
                this.instantView = instantView;
            }
        }

        public static class NewsArrayBean {
            @SerializedName("id")
            private int id;
            @SerializedName("url")
            private String url;
            @SerializedName("title")
            private String title;
            @SerializedName("groupId")
            private int groupId;
            @SerializedName("siteName")
            private String siteName;
            @SerializedName("mobileUrl")
            private String mobileUrl;
            @SerializedName("authorName")
            private String authorName;
            @SerializedName("duplicateId")
            private int duplicateId;
            @SerializedName("publishDate")
            private String publishDate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getGroupId() {
                return groupId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            public String getSiteName() {
                return siteName;
            }

            public void setSiteName(String siteName) {
                this.siteName = siteName;
            }

            public String getMobileUrl() {
                return mobileUrl;
            }

            public void setMobileUrl(String mobileUrl) {
                this.mobileUrl = mobileUrl;
            }

            public String getAuthorName() {
                return authorName;
            }

            public void setAuthorName(String authorName) {
                this.authorName = authorName;
            }

            public int getDuplicateId() {
                return duplicateId;
            }

            public void setDuplicateId(int duplicateId) {
                this.duplicateId = duplicateId;
            }

            public String getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(String publishDate) {
                this.publishDate = publishDate;
            }
        }
    }
}