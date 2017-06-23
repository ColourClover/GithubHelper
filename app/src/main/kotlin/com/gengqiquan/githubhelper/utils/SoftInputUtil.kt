package com.gengqiquan.githubhelper.utils

import android.content.Context
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

//打开或关闭软键盘
object SoftInputUtil {
    /**
     * 打卡软键盘

     */
    fun openKeybord(mEditText: EditText, mContext: Context) {
        val imm = mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN)
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    /**
     * 关闭软键盘

     */
    fun closeKeybord(mEditText: EditText, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }

    /**
     * 关闭软键盘

     */
    fun hideSoftInput(windowToken: IBinder, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }
}
