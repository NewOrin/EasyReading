package com.neworin.easyreading.ui.home

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.neworin.easyreading.R
import com.neworin.easyreading.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private var mTitles = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        home_tb.title = "ReadHub"
        home_tb.setTitleTextColor(Color.WHITE)
        home_tb.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        mTitles.add("热门话题")
        home_viewpager.adapter = HomeAdapter(supportFragmentManager, mTitles)
        home_tab_layout.setupWithViewPager(home_viewpager)
    }
}