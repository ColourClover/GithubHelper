package com.gengqiquan.githubhelper.modules.main

import android.os.Bundle
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.MVPActivity
import com.gengqiquan.githubhelper.expansions.*
import com.gengqiquan.githubhelper.modules.MainActivity
import com.gengqiquan.githubhelper.provides.APIs
import com.gengqiquan.githubhelper.provides.GithubService
import org.jetbrains.anko.startActivity


class SplashActivity : MVPActivity() {
    override fun initViews(savedInstanceState: Bundle?) {
        var userJson = getSharedString("user")
        if (userJson.isNull()) {
            retrofit.create(GithubService::class.java).user(APIs.TEST_TOKEN)
                    .applySchedulers()
                    .subscribe({
                        putSharedString("user", it.toJson())
                        go2Main()
                    }) { e ->
                        e.printStackTrace()
                        go2Main()
                    }
        } else {
            go2Main()
        }

    }

    fun go2Main() = startActivity<MainActivity>()

    override fun initData() {
    }

    override fun getLayoutID(): Int = R.layout.activity_main

    override fun inject() {

    }


}
