package com.gengqiquan.githubhelper.modules.login

import android.content.Context
import com.gengqiquan.githubhelper.AppComponent
import com.gengqiquan.githubhelper.base.ActivityModule
import com.gengqiquan.githubhelper.base.ActivityScope
import com.gengqiquan.githubhelper.expansions.applySchedulersAndLife
import com.gengqiquan.githubhelper.expansions.isEmail
import com.gengqiquan.githubhelper.expansions.isLetter
import com.gengqiquan.githubhelper.expansions.isNumber
import com.gengqiquan.githubhelper.provides.APIs
import com.gengqiquan.githubhelper.provides.GithubService
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by gengqiquan on 2017/6/23.
 */
class LoginPersenter {
    @ActivityScope val mContext: Context
    val mView: ILoginView
    val githubService: GithubService

    constructor(@ActivityScope mContext: Context, mView: ILoginView, retrofit: Retrofit) {
        this.mContext = mContext
        this.mView = mView
        this.githubService = retrofit.create(GithubService::class.java)

    }

    fun login(email: String, password: String) {
        githubService.user(APIs.TEST_TOKEN)
                .applySchedulersAndLife(mView)
                .subscribe({
                    mView.toast(it.login!!)
                }) { e -> e.printStackTrace() }
    }

     fun isEmailValid(email: String): Boolean {
        return email.isEmail()
    }

     fun isPasswordValid(password: String): Boolean {
        return password.isNumber() || password.isLetter()
    }

    @Module
    internal open class LoginPersenterModule {
        val mView: ILoginView

        constructor(mView: ILoginView) {
            this.mView = mView
        }

        @Provides
        fun provideBasePersenter(@ActivityScope context: Context, retrofit: Retrofit): LoginPersenter {
            return LoginPersenter(context, mView, retrofit)
        }
    }

    @ActivityScope
    @Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(LoginPersenterModule::class, ActivityModule::class))
    internal open interface LoginComponent {
        fun inject(activity: LoginActivity)
    }

}