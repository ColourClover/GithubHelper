package com.gengqiquan.githubhelper.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.gengqiquan.githubhelper.R
import org.jetbrains.anko.dip


/**
 * @author gengqiqauan
 * *
 * @time 2015年4月24日
 */
class TitleBar : RelativeLayout {
    var leftButton: ImageView? = null
        private set
    var midView: TextView? = null
        private set
    var rightButton: TextView? = null
        private set

    fun removeMidView() {
        this.removeView(midView)
    }

    fun setTitle(str: String) {
        midView!!.text = str
    }

    fun setRightButtonText(str: String) {
        rightButton!!.text = str
    }

    fun setTitle(resID: Int) {
        midView!!.setText(resID)
    }

    fun setLeftClickListener(listener: View.OnClickListener) :Unit{
        leftButton?.setOnClickListener(listener)
    }

    fun setRightClickListener(listener: View.OnClickListener) {
        rightButton?.setOnClickListener(listener)
    }

    fun showLeft() {
        leftButton?.visibility = View.VISIBLE
    }

    fun showRight() {
        rightButton?.visibility = View.VISIBLE
    }

    fun hideRight() {
        rightButton?.visibility = View.GONE
    }

    fun setLeftIcon(res: Int) {
        leftButton?.setBackgroundDrawable(resources.getDrawable(res))
    }

    private fun init() {

        // 左边图标
        leftButton = ImageView(context)
        leftButton!!.setBackgroundDrawable(resources.getDrawable(R.drawable.ic_arrow_left_whlte_24dp))
        val params1 = RelativeLayout.LayoutParams(dip(48), dip(48))
        params1.addRule(RelativeLayout.CENTER_VERTICAL)
        params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
        params1.setMargins(dip(10), 0, 0, 0)
        addView(leftButton, params1)
        // 标题
        midView = TextView(context)
        midView!!.text = ""
        midView!!.textSize = 18f
        midView!!.setTextColor(resources.getColor(R.color.white))
        val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(dip(68), 0, dip(80), 0)
        params.addRule(RelativeLayout.CENTER_VERTICAL)
        midView!!.setSingleLine()
        addView(midView, params)
        // 右边图标
        rightButton = TextView(context)
        //		imgright.setBackgroundResource(R.drawable.arrow_to_right_white);
        val params2 = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        params2.addRule(RelativeLayout.CENTER_VERTICAL)
        params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        params2.setMargins(0, 0, dip(15), 0)
        rightButton!!.textSize = 16f
        rightButton!!.setTextColor(context.resources.getColor(R.color.white))
        addView(rightButton, params2)
        rightButton!!.visibility = View.GONE

    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    @SuppressLint("NewApi")
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

}
