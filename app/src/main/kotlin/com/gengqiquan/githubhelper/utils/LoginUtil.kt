package com.gengqiquan.githubhelper.utils

import android.content.Context
import android.content.Intent


/**
 * 登录回调类

 * @author gengqiquan
 * *         time 2015年5月20日13:24:16
 */
object LoginUtil {
    private var mLoginActivity: Class<*>? = null
    var USER_TOKEN: String? = null
    private var mLoginCheckInterceptor: LoginCheckInterceptor = object : LoginCheckInterceptor {
        override fun isLogin(): Boolean {
            if (!checkNULL(LoginUtil.USER_TOKEN)) {
                return true
            }
            return false
        }

    }
    // 登录回调接口
    var CALLBACK: LoginUtil.ICallBack? = null

    /**
     * 检查是否登录
     * 登录直接执行操作，未登录跳转登录，登录后继续执行操作，放弃登录则什么都不做
     *
     *
     * author gengqiquan
     * date 2016/12/20 9:52
     */
    fun doActionNeedLogin(context: Context?, callBack: LoginForCallBack) {
        if (isLogin) {
            // 登录状态直接执行登录回调前需要做的操作
            callBack.callBack()
        } else {
            LoginUtil.CALLBACK = object : ICallBack {
                override fun postExec() {
                    // 登录回调后执行登录回调前需要做的操作
                    if (isLogin) {
                        // 这里需要再次判断是否登录，防止用户取消登录，取消则不执行登录成功需要执行的回调操作
                        callBack.callBack()
                        //防止调用界面的回调方法中有传进上下文的引用导致内存溢出
                        LoginUtil.CALLBACK = null
                    }
                }
            }
            if (context != null) {
                val intent = Intent(context, mLoginActivity)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }

        }
    }

    /**
     * 检查是否登录
     * 已登录什么都不做
     * 未登录跳转登录，登录后继续执行操作，放弃登录则什么都不做
     *
     *
     * author gengqiquan
     * date 2016/12/20 9:52
     */
    fun doActionJustAfterLogin(context: Context?, callBack: LoginForCallBack) {
        if (!isLogin) {
            LoginUtil.CALLBACK = object : ICallBack {
                override fun postExec() {
                    // 登录回调后执行登录回调前需要做的操作
                    if (isLogin) {
                        // 这里需要再次判断是否登录，防止用户取消登录，取消则不执行登录成功需要执行的回调操作
                        callBack.callBack()
                        //防止调用界面的回调方法中有传进上下文的引用导致内存溢出
                        LoginUtil.CALLBACK = null
                    }
                }
            }
            if (context != null) {
                val intent = Intent(context, mLoginActivity)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }

        }
    }

    /**
     * 需要登录才能执行的操作
     * 登录直接执行操作，未登录跳转登录，登录后什么都不做
     *
     *
     * author gengqiquan
     * date 2016/12/20 9:52
     */
    fun doActionAlreadyLogin(context: Context, callBack: LoginForCallBack) {
        if (isLogin) {
            // 登录状态直接执行登录回调前需要做的操作
            callBack.callBack()
        } else {
            val intent = Intent(context, mLoginActivity)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    /**
     * 跳转登录，什么都不做
     *
     *
     * author gengqiquan
     * date 2016/12/20 9:52
     */
    fun doLogin(context: Context) {
        if (!isLogin) {
            val intent = Intent(context, mLoginActivity)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    /**
     * 判断是否登录，是返回真
     *
     *
     * author gengqiquan
     * date 2016/12/20 9:57
     */
    val isLogin: Boolean
        get() {
            if (mLoginCheckInterceptor.isLogin()) {
                return true
            }
            return false
        }

    /**
     * 添加自定义判断登录拦截器
     *
     *
     * author gengqiquan
     * date 2016/12/20 15:49
     */
    fun addLoginCheckInterceptor(loginCheckInterceptor: LoginCheckInterceptor) {
        mLoginCheckInterceptor = loginCheckInterceptor
    }

    /**
     * 设置登陆跳转界面
     *
     *
     * author gengqiquan
     * date 2016/12/20 15:49
     */
    fun setLoginActivity(loginActivity: Class<*>) {
        mLoginActivity = loginActivity
    }

    // 判断是否NULL
    private fun checkNULL(str: String?): Boolean {
        return str == null || "null" == str || "" == str
    }

    // 声明一个登录成功回调的接口
    interface ICallBack {
        // 在登录操作及信息获取完成后调用这个方法来执行登录回调需要做的操作
        fun postExec()
    }

    @FunctionalInterface
    interface LoginForCallBack {
        fun callBack()
    }

    @FunctionalInterface
    interface LoginCheckInterceptor {
        fun isLogin(): Boolean
    }
}
