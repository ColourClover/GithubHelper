package com.gengqiquan.githubhelper.expansions

import android.content.Context
import com.gengqiquan.githubhelper.utils.SharedUtil

/**
 * @author hsh
 * @time 2017/6/20 020 下午 03:16.
 * @doc
 */
fun Context.getSharedString(key: String): String? = SharedUtil.getString(this, key)

fun Context.getSharedInt(key: String): Int = SharedUtil.getInt(this, key)

fun Context.getSharedBoolean(key: String, defaultValue: Boolean): Boolean = SharedUtil.getBoolean(this, key, defaultValue)

fun Context.cleanShared() = SharedUtil.clear(this)

fun Context.putSharedString(key: String, value: String) = SharedUtil.putString(this, key, value)

fun Context.putSharedInt(key: String, value: Int) = SharedUtil.putInt(this, key, value)

fun Context.putSharedBoolean(key: String, value: Boolean) = SharedUtil.putBoolean(this, key, value)

fun Context.removeShared(key: String) = SharedUtil.remove(this, key)
