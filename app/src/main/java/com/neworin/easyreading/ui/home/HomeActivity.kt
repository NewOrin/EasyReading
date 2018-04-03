package com.neworin.easyreading.ui.home

import android.os.Bundle
import com.neworin.easyreading.R
import com.neworin.easyreading.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private var mTitles = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mTitles.add("热门话题")
        home_viewpager.adapter = HomeAdapter(supportFragmentManager, mTitles)
        home_tab_layout.setupWithViewPager(home_viewpager)
    }
}