package com.neworin.easyreading.vo;

import com.google.gson.annotations.SerializedName;

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
public class NewsEntity {

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("summary")
    private String summary;
    @SerializedName("summaryAuto")
    private String summaryAuto;
    @SerializedName("url")
    private String url;
    @SerializedName("mobileUrl")
    private String mobileUrl;
    @SerializedName("siteName")
    private String siteName;
    @SerializedName("siteSlug")
    private String siteSlug;
    @SerializedName("language")
    private String language;
    @SerializedName("authorName")
    private Object authorName;
    @SerializedName("publishDate")
    private String publishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummaryAuto() {
        return summaryAuto;
    }

    public void setSummaryAuto(String summaryAuto) {
        this.summaryAuto = summaryAuto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteSlug() {
        return siteSlug;
    }

    public void setSiteSlug(String siteSlug) {
        this.siteSlug = siteSlug;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Object authorName) {
        this.authorName = authorName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
