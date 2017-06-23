package com.gengqiquan.githubhelper.base

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.Keep
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.utils.SoftInputBugFixedUtil
import com.gengqiquan.githubhelper.utils.SoftInputUtil
import com.gengqiquan.githubhelper.utils.getStatusHeight
import com.gengqiquan.githubhelper.widgets.LoadingDialog
import com.gengqiquan.githubhelper.widgets.TitleBar
import org.jetbrains.anko.dip


abstract class ThemActivity : AppCompatActivity() {
    lateinit var mContext: Context
    lateinit var mLoadView: LoadingDialog

    lateinit var mTitleBar: TitleBar
    internal val LPMM: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

    /**
     * 内容布局.
     */
    var mContentView: View? = null
    /**
     * 外层容器布局，承载内容布局和请求失败布局
     */
    var mRootView: RelativeLayout? = null
    /**
     * 最底层布局.
     */
    var mBaseView: LinearLayout? = null

    // 请求失败布局
    var mBadNet: View? = null

    /*
    *绑定控件，设置监听事件
    *@author Administrator
    *@date 2016/10/9 14:48
    */
    @Keep
    abstract fun initViews(savedInstanceState: Bundle?)

    /*
    *请求网络数据
    *@author Administrator
    *@date 2016/10/9 14:49
    */
    @Keep
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        window.setSoftInputMode(SOFT_INPUT_ADJUST_RESIZE or SOFT_INPUT_STATE_HIDDEN)
        mBaseView = LinearLayout(this)
        mRootView = RelativeLayout(this)
        mBaseView!!.orientation = LinearLayout.VERTICAL
        mContentView = layoutInflater.inflate(getLayoutID(), null)
        if (mContentView == null) {
            mContentView = RelativeLayout(this)
        }

        initToolbar()
        mContentView!!.setBackgroundColor(resources.getColor(R.color.back))
        mBaseView!!.addView(mRootView, LPMM)
        mRootView!!.addView(mContentView, LPMM)
        // 窗体动画显示
        //        overridePendingTransition(R.anim.slide_in_right, R.anim.anim_out_none);
        // 设置ContentView
        setContentView(mBaseView, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mSoftInputBugFixedUtil = SoftInputBugFixedUtil.assistActivity(this)//解决透明状态栏软件盘遮盖问题
        }
        mLoadView = LoadingDialog(mContext)
        initViews(savedInstanceState)
        initData()
    }

    private var mSoftInputBugFixedUtil: SoftInputBugFixedUtil? = null

    /**
     * 监听软键盘弹起隐藏

     * @author gengqiquan
     * *
     * @date 2017/6/12 上午11:46
     */
    protected fun setOnSoftInputChangeListener(listener: SoftInputBugFixedUtil.onSoftInputChangeListener) {
        if (mSoftInputBugFixedUtil == null) {
            return
        }
        mSoftInputBugFixedUtil!!.setOnSoftInputChangeListener(listener)
    }

    /*
       *结束界面或者界面被调入后台时结束统计
       *@author 耿
       *@date 2016/7/13 9:44
       */
    override fun onPause() {
        super.onPause()
        SoftInputUtil.hideSoftInput(mBaseView!!.windowToken, mContext)
    }

    fun setTitle(title: String) {
        mTitleBar.midView?.text = title
    }

    override fun setTitle(res: Int) {
        mTitleBar.midView?.setText(res)
    }

    var mHeader: View? = null

    private fun initToolbar() {

        mTitleBar = TitleBar(mContext)

        mHeader = View(mContext)
        mHeader!!.setBackgroundDrawable(resources.getDrawable(R.color.colorPrimaryDark))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            //透明导航栏
            mBaseView!!.addView(mHeader, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusHeight(mContext)))
            mHeader?.fitsSystemWindows = true
        }
        mBaseView!!.addView(mTitleBar, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip(48)))
        mTitleBar.setBackgroundDrawable(resources.getDrawable(R.color.colorPrimaryDark))
        mTitleBar.showLeft()
        mTitleBar.leftButton?.setOnClickListener({ onBackPressed() })
    }

    @SuppressLint("InflateParams")
    fun showBadNetView() {
        //hideLoading()
//        if (mBadNet != null)
//            mRootView!!.removeView(mBadNet)
//        mBadNet = mInflater.from(mContext).inflate(R.layout.bad_network, null)
//        mRootView!!.addView(mBadNet, LPMM)
//        val button = mBadNet!!.findViewById(R.id.reload)
//        mBadNet!!.visibility = View.VISIBLE
//        button.setOnClickListener {
//            mRootView!!.removeView(mBadNet)
//            showLoading()
//            initData()
//        }
    }

//    @SuppressLint("InflateParams")
//    fun getBadNetView(): View {
//        hideLoading()
//        if (mBadNet != null)
//            mRootView!!.removeView(mBadNet)
//        mBadNet = mInflater.from(mContext).inflate(R.layout.bad_network, null)
//        mRootView!!.addView(mBadNet, LPMM)
//        val button = mBadNet!!.findViewById(R.id.reload)
//        mBadNet!!.visibility = View.VISIBLE
//        return button
    // }

    abstract fun getLayoutID(): Int

    override fun onDestroy() {
        if (mLoadView.isShowing)    //防止耗时操作后关闭加载框时界面已经被销毁
            mLoadView.dismiss()
        super.onDestroy()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        SoftInputUtil.hideSoftInput(mBaseView!!.windowToken, mContext)
    }
}
