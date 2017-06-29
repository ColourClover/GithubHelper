package com.gengqiquan.githubhelper.utils

import android.app.Activity

import java.util.ArrayList

/**
 * Created by 耿 on 2016/8/30.
 */
object ExitUtil {

    var activity_: MutableList<Activity> = ArrayList()

    fun addActivity(activity: Activity) {
        activity_.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activity_.remove(activity)
    }

    fun exit() {
        val copy = ArrayList(activity_)
        for (activity in copy) {
            activity.finish()
        }
        System.exit(0)
    }

    fun finish() {
        val copy = ArrayList(activity_)
        for (activity in copy) {
            activity.finish()
        }
    }

    fun finish(activity: Class<*>) {
        var act_: Activity? = null
        for (act in activity_) {
            if (act.javaClass.name == activity.name) {
                act_ = act
            }
        }
        if (act_ != null) {
            activity_.remove(act_)
            act_.finish()
        }
    }

}
