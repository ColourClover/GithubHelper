package com.gengqiquan.githubhelper.base

import android.os.Bundle
import com.gengqiquan.githubhelper.App
import com.gengqiquan.githubhelper.DaggerAppComponent
import retrofit2.Retrofit
import javax.inject.Inject


abstract class DaggerActivity : BaseActivity() {
    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).component.inject(this)
        inject()
        super.onCreate(savedInstanceState)
    }

    abstract fun inject()
    /**
     * 禁止重写该方法，防止同名方法

     * @author gengqiquan
     * *
     * @date 2017/3/28 下午2:27
     */
    val activityModule: ActivityModule
        get() = ActivityModule(this)


}
