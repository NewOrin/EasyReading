package com.neworin.easyreading.utils

import android.widget.Toast
import com.neworin.easyreading.BaseApplication

/**
 * author : ZhangFubin
 * time   : 2018/04/03
 * desc   :
 */
fun showToast(msg: String?) {
    Toast.makeText(BaseApplication.INSTANCE, msg, Toast.LENGTH_SHORT).show()
}