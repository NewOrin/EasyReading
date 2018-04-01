package com.neworin.easyreading.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.neworin.easyreading.R
import com.neworin.easyreading.http.RetrofitFactory
import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiService = RetrofitFactory.createRetrofit()
        main_btn.setOnClickListener {
            apiService.getTopicList("", 20)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Consumer<TopicEntity> {
                        override fun accept(t: TopicEntity) {
                            Log.d("neworin", t.data.toString())
                        }
                    }, object : Consumer<Throwable> {
                        override fun accept(t: Throwable?) {
                        }
                    })
        }
    }
}
