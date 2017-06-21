package com.gengqiquan.githubhelper

import android.app.Application
import com.gengqiquan.githubhelper.base.AppModule
import com.gengqiquan.githubhelper.provides.APIs
import com.sunshine.retrofit.HttpUtil

/**
 * Created by gengqiquan on 2017/6/21.
 */

class App : Application() {
    lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        component.inject(this)
        httpInit()
    }

    private fun httpInit() {
        HttpUtil.SingletonBuilder(this, APIs.GITHUB_DOMAIN)
                .build()
    }


}
