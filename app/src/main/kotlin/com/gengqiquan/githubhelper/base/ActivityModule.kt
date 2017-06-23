package com.gengqiquan.githubhelper.base

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module @ActivityScope
class ActivityModule {
    @ActivityScope  private val activity: Activity
    @ActivityScope   var mBaseView: IBaseView
    @ActivityScope  var mContext: Context

    constructor(activity: Activity) {
        this.activity = activity
        this.mBaseView = activity as IBaseView
        this.mContext = activity as Context
    }

    @ActivityScope
    @Provides
    internal fun activity(): Activity {
        return this.activity
    }

    @ActivityScope
    @Provides
    internal fun provideContext(): Context {
        return this.activity as Context
    }

    @ActivityScope
    @Provides
    internal fun provideIBaseView(): IBaseView {
        return this.mBaseView
    }


}