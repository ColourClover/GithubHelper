package com.gengqiquan.githubhelper.base

import android.support.annotation.CallSuper
import com.gengqiquan.githubhelper.expansions.error
import com.gengqiquan.githubhelper.expansions.success
import com.gengqiquan.githubhelper.expansions.toast
import com.trello.rxlifecycle2.LifecycleTransformer

/**
 * Created by gengqiquan on 2017/3/24.
 */

abstract class MVPActivity : RxBaseActivity(), IBaseView {
    override fun toast(msg: String) {
        mContext.toast(msg)
    }

    override fun success(msg: String) {
        mContext.success(msg)
    }

    override fun error(msg: String) {
        mContext.error(msg)
    }


    override fun showLoading() {
        mLoadView.show()
    }

    override fun showLoading(msg: String) {
        mLoadView.setMessage(msg)
        mLoadView.show()
    }

    override fun hideLoading() {
        mLoadView.setMessage("加载中")
        mLoadView.dismiss()
    }


    override fun showNetError() {
//        showBadNetView()
    }


    @CallSuper
    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return bindToLifecycle()
    }
}
