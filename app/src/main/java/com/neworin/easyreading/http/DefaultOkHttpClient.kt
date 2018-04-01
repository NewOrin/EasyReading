package com.neworin.easyreading.http

import com.neworin.easyreading.BaseApplication
import com.neworin.easyreading.R
import okhttp3.OkHttpClient
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   : 构造HttpClient
 */
object DefaultOkHttpClient {
    //默认超时时间10s
    private val DEFAULT_TIME_OUT = 10

    fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.readTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.writeTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        setCertificates(builder)
        return builder.build()
    }

    private fun setCertificates(builder: OkHttpClient.Builder) {
        try {
            val certificateFactory = CertificateFactory.getInstance("X.509")
            val input = BaseApplication.INSTANCE.resources.openRawResource(R.raw.readhub)
            val trustStore = KeyStore.getInstance(KeyStore.getDefaultType())
            trustStore.load(null)
            trustStore.setCertificateEntry("", certificateFactory.generateCertificate(input))
            val sslContext = SSLContext.getInstance("TLS")

            val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
            trustManagerFactory.init(trustStore)
            sslContext.init(
                    null,
                    trustManagerFactory.trustManagers,
                    SecureRandom()
            )
            builder.sslSocketFactory(sslContext.socketFactory)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}