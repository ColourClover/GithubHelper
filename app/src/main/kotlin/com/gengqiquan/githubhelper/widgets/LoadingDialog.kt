package com.gengqiquan.githubhelper.widgets

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

import com.gengqiquan.githubhelper.R

class LoadingDialog(internal var mContext: Context) {

    var mProgressDialog: ProgressDialog = ProgressDialog(mContext, R.style.DialogStyle)
    internal var mContentView: View = LayoutInflater.from(mContext).inflate(R.layout.dialog_loading, null)

    fun show() {
        if (mContext is Activity) {
            if ((mContext as Activity).isFinishing)
                return
        }
        if (isShowing) {
            return
        }
        mProgressDialog.show()
        mProgressDialog.setCancelable(false)
        mProgressDialog.setContentView(mContentView)
    }

    fun setCancelable(cancelable: Boolean) {
        mProgressDialog.setCancelable(cancelable)
    }

    fun dismiss() {
        if (mContext is Activity) {
            if ((mContext as Activity).isFinishing)
                return
        }
        mProgressDialog.dismiss()
    }

    fun setMessage(mess: String) {
        val message = mContentView.findViewById(R.id.msg) as TextView
        message.text = mess
    }

    val isShowing: Boolean
        get() = mProgressDialog.isShowing
}