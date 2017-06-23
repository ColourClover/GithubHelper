package com.che300.kotlin.extand

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

/**
 * Created by gengqiquan on 2017/6/15.
 */

fun ImageView.load(uri: String) = Glide.with(this).load(uri).into(this)

fun ImageView.load(uri: Int) = Glide.with(this).load(uri).into(this)

fun ImageView.load(uri: File) = Glide.with(this).load(uri).into(this)