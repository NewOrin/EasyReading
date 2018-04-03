package com.neworin.easyreading.ui.home

import android.os.Bundle
import com.neworin.easyreading.R
import com.neworin.easyreading.base.BaseActivity
import com.neworin.easyreading.ui.topic.TopicFragment

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportFragmentManager.beginTransaction().add(R.id.home_container, TopicFragment()).commit()
    }
}
