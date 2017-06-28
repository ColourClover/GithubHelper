package com.gengqiquan.githubhelper.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gengqiquan.githubhelper.widgets.LoadingDialog


/**
 * Created by xhe on 2017/3/29.
 */

abstract class BaseFragment : Fragment() {
    lateinit var mContext: Context
    lateinit var mContentView: View

    /**
     * Fragment当前状态是否可见
     */
    protected var mIsVisible: Boolean = false
    protected var mLoadView: LoadingDialog? = null

    @LayoutRes
    abstract fun getLayoutID(): Int

    abstract fun initView(view: View, savedInstanceState: Bundle?)

    abstract fun initData()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContentView = inflater!!.inflate(getLayoutID(), null)
        mLoadView = LoadingDialog(mContext)
        return mContentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view, savedInstanceState)
        initData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        mIsVisible = userVisibleHint
    }


}
