package com.gengqiquan.githubhelper.utils

import android.content.Context
import android.os.Looper
import android.util.Log
import android.widget.Toast

import java.io.PrintWriter
import java.io.StringWriter

class CustomCrashHandler private constructor() : Thread.UncaughtExceptionHandler {
    lateinit var mContext: Context
    /**
     * 异常发生时，系统回调的函数，我们在这里处理一些操作
     */
    override fun uncaughtException(thread: Thread, ex: Throwable) {
        obtainExceptionInfo(ex)
        ex.printStackTrace()
        //提示用户程序即将退出
        showToast(mContext, "很抱歉，应用遭遇异常，即将退出！")
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        //完美退出程序方法
        ExitUtil.exit()
    }


    /**
     * 为我们的应用程序设置自定义Crash处理
     */
    fun setCustomCrashHanler(context: Context) {
        mContext = context
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    /**
     * 显示提示信息，需要在线程中显示Toast

     * @param context
     * *
     * @param msg
     */
    private fun showToast(context: Context, msg: String) {
        Thread(Runnable {
            Looper.prepare()
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
            Looper.loop()
        }).start()
    }

    /**
     * 获取系统未捕捉的错误信息

     * @param throwable
     * *
     * @return
     */
    private fun obtainExceptionInfo(throwable: Throwable) {
        val mStringWriter = StringWriter()
        val mPrintWriter = PrintWriter(mStringWriter)
        throwable.printStackTrace(mPrintWriter)
        mPrintWriter.close()

        Log.e(TAG, mStringWriter.toString())
    }

    companion object {
        private val TAG = "Activity"
        /**
         * 单例模式，保证只有一个CustomCrashHandler实例存在

         * @return
         */
        val instance = CustomCrashHandler()
    }
}
