package com.neworin.easyreading.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.neworin.easyreading.ui.home.news.NewsFragment
import com.neworin.easyreading.ui.home.topic.TopicFragment

/**
 * author : ZhangFubin
 * time   : 2018/04/03
 * desc   : 首页Fragment Tab Adapter
 */
class HomeAdapter(fm: FragmentManager, var list: ArrayList<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
            val bundle = Bundle()
        return when (position) {
            1 -> {
                bundle.putInt(NewsFragment.PAGE_TYPE_KEY, NewsFragment.PAGE_TYPE_TECH)
                NewsFragment.newInstance(bundle)
            }
            2 -> {
                bundle.putInt(NewsFragment.PAGE_TYPE_KEY, NewsFragment.PAGE_TYPE_DEV)
                NewsFragment.newInstance(bundle)
            }
            3 -> {
                bundle.putInt(NewsFragment.PAGE_TYPE_KEY, NewsFragment.PAGE_TYPE_BLOCK_CHAIN)
                NewsFragment.newInstance(bundle)
            }
            else -> TopicFragment.newInstance(Bundle())
        }
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position]
    }
}