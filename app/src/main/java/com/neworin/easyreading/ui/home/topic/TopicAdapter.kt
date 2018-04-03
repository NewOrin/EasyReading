package com.neworin.easyreading.ui.home.topic

import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.TextAppearanceSpan
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.neworin.easyreading.R
import com.neworin.easyreading.utils.formatTime
import com.neworin.easyreading.vo.TopicEntity

/**
 * author : ZhangFubin
 * time   : 2018/04/03
 * desc   :
 */
class TopicAdapter(layoutId: Int, datas: ArrayList<TopicEntity.DataBean>) : BaseQuickAdapter<TopicEntity.DataBean, BaseViewHolder>(layoutId, datas) {
    override fun convert(helper: BaseViewHolder, item: TopicEntity.DataBean?) {
        helper.setText(R.id.item_topic_title, item?.title)
        helper.setText(R.id.item_topic_summary, item?.summary)
        val ssb = SpannableStringBuilder(item?.title + "   " + formatTime(item?.publishDate))
        val textAppearanceSpan = TextAppearanceSpan(mContext, R.style.time_textAppearance)
        ssb.setSpan(textAppearanceSpan, item?.title?.length ?: 0
        +2, ssb.length, SpannableString.SPAN_INCLUSIVE_INCLUSIVE)
        helper.setText(R.id.item_topic_title, ssb)
    }
}