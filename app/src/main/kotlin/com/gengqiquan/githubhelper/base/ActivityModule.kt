package com.gengqiquan.githubhelper.base

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    private val activity: Activity
    internal var mBaseView: IBaseView

    constructor(activity: Activity) {
        this.activity = activity
        this.mBaseView = activity as IBaseView
    }

    constructor(activity: Activity, iBaseView: IBaseView) {
        this.activity = activity
        this.mBaseView = iBaseView
    }

    @ActivityScope
    @Provides
    internal fun activity(): Activity {
        return this.activity
    }

    @ActivityScope
    @Provides
    internal fun provideContext(): Context {
        return this.activity
    }

    @ActivityScope
    @Provides
    internal fun provideIBaseView(): IBaseView {
        return this.mBaseView
    }


}