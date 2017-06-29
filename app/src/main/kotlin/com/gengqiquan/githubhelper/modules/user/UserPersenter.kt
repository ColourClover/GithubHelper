package com.gengqiquan.githubhelper.modules.user

import android.content.Context
import com.gengqiquan.githubhelper.AppComponent
import com.gengqiquan.githubhelper.base.ActivityModule
import com.gengqiquan.githubhelper.base.ActivityScope
import com.gengqiquan.githubhelper.expansions.BindViewLifeAndSchedulers
import com.gengqiquan.githubhelper.provides.GithubService
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by gengqiquan on 2017/6/29.
 */
class UserPersenter {
    @ActivityScope val mContext: Context
    val mView: IUserView
    val retrofit: Retrofit

    constructor(mContext: Context, mView: IUserView, retrofit: Retrofit) {
        this.mContext = mContext
        this.mView = mView
        this.retrofit = retrofit

    }

    fun getUser(userLogin: String) {
        retrofit.create(GithubService::class.java).getUser(userLogin)
                .BindViewLifeAndSchedulers(mView)
                .subscribe({
                    mView.setUserInfo(it)
                }) { e ->
                    e.printStackTrace()
                }
    }

    @Module
    internal open class UserPersenterModule {
        val mView: IUserView

        constructor(mView: IUserView) {
            this.mView = mView
        }

        @Provides
        fun provideBasePersenter(@ActivityScope context: Context, retrofit: Retrofit): UserPersenter {
            return UserPersenter(context, mView, retrofit)
        }
    }

    @ActivityScope
    @Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(UserPersenterModule::class, ActivityModule::class))
    internal open interface UserComponent {
        fun inject(activity: UserInfoActivity)
    }

}