package com.gengqiquan.githubhelper;

import android.content.Context
import android.location.LocationManager
import com.gengqiquan.githubhelper.base.AppModule
import com.gengqiquan.githubhelper.base.AppScope
import com.gengqiquan.githubhelper.base.DaggerActivity
import com.gengqiquan.githubhelper.base.DaggerFragment
import com.gengqiquan.githubhelper.data.User
import com.gengqiquan.githubhelper.provides.GithubService
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: App)
    fun inject(activity: DaggerActivity)
    fun inject(fragment: DaggerFragment)

    fun getApp(): App
    fun getUser(): User
    fun getRetrofit(): Retrofit
    fun getOkHttpClient(): OkHttpClient
}