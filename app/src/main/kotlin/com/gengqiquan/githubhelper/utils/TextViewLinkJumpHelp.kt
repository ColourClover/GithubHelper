package com.gengqiquan.githubhelper.utils

import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.TextView

/**
 * Created by gengqiquan on 2017/6/29.
 */
fun setLinkJump(tv: TextView, html: String, color: Int, textClick: TextClick) {
    val charSequence = Html.fromHtml(html)
    val builder = SpannableStringBuilder(
            charSequence)
    val urlSpans = builder.getSpans(0, charSequence.length,
            URLSpan::class.java)
    builder.clearSpans()
    for (url in urlSpans) {

        builder.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                // 捕获<a>标签点击事件，及对应超链接link
                textClick.click(url.url)
            }
        }, charSequence.getSpanStart(url), charSequence.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.setSpan(ColorSpan(color), charSequence.getSpanStart(url), charSequence.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    tv.text = builder
    tv.linksClickable = true
    tv.movementMethod = LinkMovementMethod.getInstance()

}

interface TextClick {
    fun click(url: String)
}