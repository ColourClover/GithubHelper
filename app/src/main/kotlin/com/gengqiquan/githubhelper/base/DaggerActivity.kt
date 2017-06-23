package com.gengqiquan.githubhelper.base

import android.os.Bundle
import retrofit2.Retrofit
import javax.inject.Inject


abstract class DaggerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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
