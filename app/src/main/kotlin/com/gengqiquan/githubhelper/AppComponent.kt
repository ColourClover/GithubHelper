package com.gengqiquan.githubhelper;

import com.gengqiquan.githubhelper.base.AppModule
import com.gengqiquan.githubhelper.base.DaggerActivity
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: App)
    fun inject(activity: DaggerActivity)
}