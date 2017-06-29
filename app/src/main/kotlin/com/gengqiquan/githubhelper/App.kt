package com.gengqiquan.githubhelper

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.gengqiquan.githubhelper.base.AppModule
import com.gengqiquan.githubhelper.modules.login.LoginActivity
import com.gengqiquan.githubhelper.provides.APIs
import com.gengqiquan.githubhelper.utils.CustomCrashHandler
import com.gengqiquan.githubhelper.utils.LoginUtil
import com.sunshine.retrofit.HttpUtil
import com.sunshine.retrofit.cacahe.CacheProvide
import com.sunshine.retrofit.interceptor.CacheInterceptor
import com.sunshine.retrofit.interceptor.HttpLoggingInterceptor
import es.dmoral.toasty.Toasty
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by gengqiquan on 2017/6/21.
 */

class App : Application() {
    companion object {
        internal lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        val okHttpClient = getOkHttpClient()
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(APIs.GITHUB_DOMAIN + "/")
                .client(okHttpClient).build()
        component = DaggerAppComponent.builder().appModule(AppModule(this, okHttpClient, retrofit)).build()
        // component.inject(this)
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
            ARouter.printStackTrace()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
        LoginUtil.setLoginActivity(LoginActivity::class.java)
        LoginUtil.USER_TOKEN = APIs.TEST_TOKEN
        CustomCrashHandler.instance.setCustomCrashHanler(this)
    }

    private fun httpInit() {
        HttpUtil.SingletonBuilder(this, APIs.GITHUB_DOMAIN)
                .build()
    }

    fun getOkHttpClient(): OkHttpClient {
        var client = OkHttpClient.Builder()
                .addNetworkInterceptor(CacheInterceptor())
                .cache(CacheProvide(this).provideCache())
                .retryOnConnectionFailure(true)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(8, TimeUnit.SECONDS)
                .writeTimeout(8, TimeUnit.SECONDS)
                .build()
        if (BuildConfig.DEBUG) {//printf logs while  debug
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            client = client.newBuilder().addInterceptor(logging).build()
        }
        return client
    }


}
