package com.gengqiquan.githubhelper.data

import android.os.Bundle

/**
 * Created by gengqiquan on 2017/6/30.
 */
data class MenuItem(val resID: Int,
                    val title: String,
                    val number: Int?,
                    val router: String?,
                    val bundle: Bundle?)