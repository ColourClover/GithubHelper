package com.gengqiquan.githubhelper

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.gengqiquan.githubhelper.base.AppModule
import com.gengqiquan.githubhelper.provides.APIs
import com.sunshine.retrofit.HttpUtil
import es.dmoral.toasty.Toasty

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
        Toasty.Config.getInstance()
//                .setErrorColor(@ColorInt int errorColor) // optional
//                .setInfoColor(@ColorInt int infoColor) // optional
//                .setSuccessColor(@ColorInt int successColor) // optional
//                .setWarningColor(@ColorInt int warningColor) // optional
//                .setTextColor(@ColorInt int textColor) // optional
//                .tintIcon(boolean tintIcon) // optional (apply textColor also to the icon)
//                .setToastTypeface(@NonNull Typeface typeface) // optional
//                .setTextSize(int sizeInSp) // optional
                .apply()// required

        if (BuildConfig.DEBUG) {
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }

    private fun httpInit() {
        HttpUtil.SingletonBuilder(this, APIs.GITHUB_DOMAIN)
                .build()
    }


}
