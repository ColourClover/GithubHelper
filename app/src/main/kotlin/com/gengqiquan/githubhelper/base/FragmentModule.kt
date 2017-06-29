package com.gengqiquan.githubhelper.base

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module @ActivityScope
class FragmentModule {
    @ActivityScope private val activity: Activity
    @ActivityScope var mBaseView: IBaseView
    @ActivityScope var mContext: Context

    constructor(fragment: DaggerFragment) {
        this.activity = fragment.activity
        this.mBaseView = fragment as IBaseView
        this.mContext = activity
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