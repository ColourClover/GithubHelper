package com.che300.kotlin.extand


/**
 * Created by gengqiquan on 2017/6/15.
 */
fun String?.isNull(): Boolean = this.isNullOrBlank() || "null" == this || "" == this

fun String?.notNull(): Boolean = !this.isNull()
fun Boolean.not(): Boolean = !this
