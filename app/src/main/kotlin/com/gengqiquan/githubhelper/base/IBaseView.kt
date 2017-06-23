package com.gengqiquan.githubhelper.base


import android.support.annotation.UiThread

import com.trello.rxlifecycle.LifecycleTransformer

/**
 * 基础 BaseView 接口
 */
interface IBaseView {

    /**
     * 显示加载动画
     */
    @UiThread
    fun showLoading()

    /**
     * 显示加载动画
     */
    @UiThread
    fun showLoading(msg: String)

    /**
     * 隐藏加载
     */
    @UiThread
    fun hideLoading()

    /**
     * 显示加载失败
     */
    @UiThread
    fun showNetError()

    /**
     * 显示toast
     */
    @UiThread
    fun toast(msg: String)

    /**
     * 显示toast
     */
    @UiThread
    fun success(msg: String)

    /**
     * 显示toast
     */
    @UiThread
    fun error(msg: String)

    /**
     * 绑定生命周期

     * @param <T>
     * *
     * @return
    </T> */
    fun <T> bindToLife(): LifecycleTransformer<T>

}
