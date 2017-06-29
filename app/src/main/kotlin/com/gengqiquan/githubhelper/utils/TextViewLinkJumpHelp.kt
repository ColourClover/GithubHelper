package com.gengqiquan.githubhelper.utils

import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by gengqiquan on 2017/6/29.
 */
fun setLinkJump(tv: TextView, html: String, color: Int) {
    val charSequence = Html.fromHtml(html)
    val builder = SpannableStringBuilder(
            charSequence)
    val urlSpans = builder.getSpans(0, charSequence.length,
            URLSpan::class.java)
    builder.clearSpans()
    for (url in urlSpans) {
        builder.setSpan(TextClick(url.url), charSequence.getSpanStart(url), charSequence.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.setSpan(ColorSpan(color), charSequence.getSpanStart(url), charSequence.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    tv.text = builder
    tv.linksClickable = true
    tv.movementMethod = LinkMovementMethod.getInstance()

}

fun router(uri: String) {
    var url = uri
    val bundle = Bundle()
    if (url.contains("?")) {
        var data = url.split("?")
        if (data.size > 1) {
            val params = data[1].split("&".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
            params.map { param -> param.split("=".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray() }
                    .forEach { bundle.putString(it[0], it[1]) }

        }
        url = data[0]
    }
    ARouter.getInstance().build(url).with(bundle).navigation()
}

class TextClick(var url: String) : ClickableSpan() {
    override fun onClick(widget: View) {
        router(url)
    }

}