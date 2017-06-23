package com.gengqiquan.githubhelper.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * © 2012 amsoft.cn 名称：AbSharedUtil.java 描述：保存到 SharedPreferences 的数据.

 * @version v1.0
 * *
 * @date：2014-10-09 下午11:52:13
 */
object SharedUtil {

    private val SHARED_PATH = "share"

    fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return context.applicationContext.getSharedPreferences(
                SHARED_PATH, Context.MODE_PRIVATE)
    }

    fun putInt(context: Context, key: String, value: Int) {
        val sharedPreferences = getDefaultSharedPreferences(context)
        val edit = sharedPreferences.edit()
        edit.putInt(key, value)
        edit.commit()
    }

    fun getInt(context: Context, key: String): Int {
        val sharedPreferences = getDefaultSharedPreferences(context)
        return sharedPreferences.getInt(key, 0)
    }

    fun putString(context: Context, key: String, value: String) {
        val sharedPreferences = getDefaultSharedPreferences(context)
        val edit = sharedPreferences.edit()
        edit.putString(key, value)
        edit.commit()
    }

    /**
     * 移除某个key值已经对应的值

     * @param context
     */
    fun clear(context: Context) {
        val sharedPreferences = getDefaultSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.commit()
    }

    /**
     * 移除某个key值已经对应的值

     * @param context
     * *
     * @param key
     */
    fun remove(context: Context, key: String) {
        val sharedPreferences = getDefaultSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.commit()
    }

    fun getString(context: Context, key: String): String {
        val sharedPreferences = getDefaultSharedPreferences(context)
        return sharedPreferences.getString(key, null)
    }

    fun putBoolean(context: Context, key: String, value: Boolean) {
        val sharedPreferences = getDefaultSharedPreferences(context)
        val edit = sharedPreferences.edit()
        edit.putBoolean(key, value)
        edit.commit()
    }

    fun getBoolean(context: Context, key: String,
                   defValue: Boolean): Boolean {
        val sharedPreferences = getDefaultSharedPreferences(context)
        return sharedPreferences.getBoolean(key, defValue)
    }

}
