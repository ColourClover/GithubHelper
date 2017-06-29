package com.gengqiquan.githubhelper.utils;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CustomCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "Activity";
    private Context mContext;
    private static CustomCrashHandler mInstance = new CustomCrashHandler();


    private CustomCrashHandler() {
    }

    /**
     * 单例模式，保证只有一个CustomCrashHandler实例存在
     *
     * @return
     */
    public static CustomCrashHandler getInstance() {
        return mInstance;
    }

    /**
     * 异常发生时，系统回调的函数，我们在这里处理一些操作
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        obtainExceptionInfo(ex);
        ex.printStackTrace();
        //提示用户程序即将退出
        showToast(mContext, "很抱歉，应用遭遇异常，即将退出！");
        try {
            thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //完美退出程序方法
        ExitUtil.exit();
    }


    /**
     * 为我们的应用程序设置自定义Crash处理
     */
    public void setCustomCrashHanler(Context context) {
        mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 显示提示信息，需要在线程中显示Toast
     *
     * @param context
     * @param msg
     */
    private void showToast(final Context context, final String msg) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }).start();
    }

    /**
     * 获取系统未捕捉的错误信息
     *
     * @param throwable
     * @return
     */
    private void obtainExceptionInfo(Throwable throwable) {
        StringWriter mStringWriter = new StringWriter();
        PrintWriter mPrintWriter = new PrintWriter(mStringWriter);
        throwable.printStackTrace(mPrintWriter);
        mPrintWriter.close();

        Log.e(TAG, mStringWriter.toString());
    }
}
