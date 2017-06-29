package com.gengqiquan.githubhelper.expansions

import android.support.annotation.CheckResult
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

/**
 * Created by gengqiquan on 2017/6/15.
 */

fun ImageView.load(uri: String) = Glide.with(this).load(uri).into(this)

fun ImageView.load(uri: Int) = Glide.with(this).load(uri).into(this)

fun ImageView.load(uri: File) = Glide.with(this).load(uri).into(this)
/**
 *add layout to viewgroup
 *@author gengqiquan
 *@date 2017/6/27 上午10:07
 */
fun ViewGroup.addView(@LayoutRes id: Int) = LayoutInflater.from(this.context).inflate(id, this, true)

/**
 *inflate a layout with it's layoutParams
 *@author gengqiquan
 *@date 2017/6/27 上午10:07
 */
fun ViewGroup.inflate(@LayoutRes id: Int) = LayoutInflater.from(this.context).inflate(id, this, false)

/**
 *inflate a layout without it's layoutParams
 *@author gengqiquan
 *@date 2017/6/27 上午10:07
 */
@CheckResult(suggest = "the layout need to be added to Viewgroup")
fun ViewGroup.inflateWithNoParams(@LayoutRes id: Int) = LayoutInflater.from(this.context).inflate(id, null)