package com.gengqiquan.githubhelper.base

import android.os.Bundle
import android.support.annotation.CallSuper
import com.gengqiquan.githubhelper.utils.ExitUtil

abstract class BaseActivity : ThemActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ExitUtil.addActivity(this)
        super.onCreate(savedInstanceState)

    }

    @CallSuper
    override fun finish() {
        super.finish()
        ExitUtil.removeActivity(this)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        ExitUtil.removeActivity(this)
    }
}
