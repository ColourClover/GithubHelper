package com.che300.kotlin.extand

import android.content.Context
import com.gengqiquan.githubhelper.utils.SharedUtil

/**
 * @author hsh
 * @time 2017/6/20 020 下午 03:16.
 * @doc
 */
fun Context.getString(key: String): String = SharedUtil.getString(this, key)

fun Context.getInt(key: String): Int = SharedUtil.getInt(this, key)

fun Context.getBoolean(key: String, defaultValue: Boolean): Boolean = SharedUtil.getBoolean(this, key, defaultValue)

fun Context.clean() = SharedUtil.clear(this)

fun Context.putString(key: String, value: String) = SharedUtil.putString(this, key, value)

fun Context.putInt(key: String, value: Int) = SharedUtil.putInt(this, key, value)

fun Context.putBoolean(key: String, value: Boolean) = SharedUtil.putBoolean(this, key, value)

fun Context.remove(key: String) = SharedUtil.remove(this, key)
