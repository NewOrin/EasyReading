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
        if (position == 1) {
            return NewsFragment.newInstance(Bundle())
        }
        return TopicFragment.newInstance(Bundle())
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position]
    }
}