package com.gengqiquan.githubhelper.base

import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager
import com.gengqiquan.githubhelper.App
import com.gengqiquan.githubhelper.BuildConfig
import com.gengqiquan.githubhelper.provides.APIs
import com.gengqiquan.githubhelper.provides.GithubService
import com.sunshine.retrofit.cacahe.CacheProvide
import com.sunshine.retrofit.interceptor.CacheInterceptor
import com.sunshine.retrofit.interceptor.HttpLoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by gengqiquan on 2017/6/21.
 */
@Module
class AppModule(private val application: App) {
    @Provides @Singleton @AppScope
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides @Singleton
    fun provideLocationManager(): LocationManager {
        return application.getSystemService(LOCATION_SERVICE) as LocationManager
    }

    @Provides @Singleton
    fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

    @Provides @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(APIs.GITHUB_DOMAIN + "/")
                .client(provideOkHttpClient()).build()
    }

    @Provides @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        var client = OkHttpClient.Builder()
                .addNetworkInterceptor(CacheInterceptor())
                .cache(CacheProvide(application).provideCache())
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