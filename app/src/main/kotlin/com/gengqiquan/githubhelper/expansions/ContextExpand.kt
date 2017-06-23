@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.gengqiquan.githubhelper.expansions

import android.content.Context
import android.widget.Toast
import es.dmoral.toasty.Toasty

fun Context.toast(msg: String) = Toasty.normal(this, msg, Toast.LENGTH_SHORT).show()
fun Context.showToast(msg: String) = Toasty.normal(this, msg, Toast.LENGTH_SHORT).show()
fun Context.success(msg: String) = Toasty.success(this, msg, Toast.LENGTH_SHORT, true).show()
fun Context.error(msg: String) = Toasty.error(this, msg, Toast.LENGTH_SHORT, true).show()