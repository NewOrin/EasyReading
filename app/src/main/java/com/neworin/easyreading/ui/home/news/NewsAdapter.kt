package com.neworin.easyreading.ui.home.news

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.neworin.easyreading.R
import com.neworin.easyreading.utils.formatTime
import com.neworin.easyreading.vo.NewsEntity

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
class NewsAdapter(layoutId: Int, datas: ArrayList<NewsEntity>) : BaseQuickAdapter<NewsEntity, BaseViewHolder>(layoutId, datas) {

    override fun convert(helper: BaseViewHolder?, item: NewsEntity?) {
        helper?.setText(R.id.item_news_title, item?.title)
        helper?.setText(R.id.item_news_summary, item?.summaryAuto)
        if (item?.authorName != null) {
            helper?.setText(R.id.item_news_site, "${item.siteName}/${item.authorName}")
        } else {
            helper?.setText(R.id.item_news_site, item?.siteName)
        }
        helper?.setText(R.id.item_news_time, formatTime(item?.publishDate))
    }
}