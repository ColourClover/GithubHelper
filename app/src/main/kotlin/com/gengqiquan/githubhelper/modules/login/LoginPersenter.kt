package com.gengqiquan.githubhelper.modules.login

import android.content.Context
import com.gengqiquan.githubhelper.AppComponent
import com.gengqiquan.githubhelper.base.ActivityModule
import com.gengqiquan.githubhelper.base.ActivityScope
import com.gengqiquan.githubhelper.base.AppModule
import com.gengqiquan.githubhelper.base.AppScope
import com.gengqiquan.githubhelper.expansions.applySchedulersAndLife
import com.gengqiquan.githubhelper.provides.APIs
import com.gengqiquan.githubhelper.provides.GithubService
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

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
        githubService!!.authorize(APIs.CLIENT_ID, email, APIs.REDIRECT_URI)
                .applySchedulersAndLife(mView)
                .subscribe({
                    mView.toast(it)
                }) { e -> e.printStackTrace() }
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