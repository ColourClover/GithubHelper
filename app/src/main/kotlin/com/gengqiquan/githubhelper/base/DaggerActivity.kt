package com.gengqiquan.githubhelper.base

import android.os.Bundle
import com.gengqiquan.githubhelper.App
import retrofit2.Retrofit
import javax.inject.Inject


abstract class DaggerActivity : ThemActivity() {
    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
        inject()
    }

    abstract fun inject()
}
