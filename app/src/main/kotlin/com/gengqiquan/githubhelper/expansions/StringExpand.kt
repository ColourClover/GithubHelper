package com.gengqiquan.githubhelper.expansions

/**
 * Created by gengqiquan on 2017/6/23.
 */
/**
 * 描述：是否是邮箱.
 *
 * @param str
 *            指定的字符串
 * @return 是否是邮箱:是为true，否则false
 */
fun String.isEmail(): Boolean {
    var isEmail: Boolean = false
    val expr = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
    if (this.matches(expr.toRegex())) {
        isEmail = true
    }
    return isEmail
}

/**
 * 描述：是否只是数字.

 * @param str
 * *            指定的字符串
 * *
 * @return 是否只是数字:是为true，否则false
 */
fun String.isNumber(): Boolean {
    var isNumber: Boolean = false
    val expr = "^[0-9]+$"
    if (this.matches(expr.toRegex())) {
        isNumber = true
    }
    return isNumber
}

/**
 * 描述：是否只是字母.

 * @param str
 * *            指定的字符串
 * *
 * @return 是否只是字母:是为true，否则false
 */
fun String.isLetter(): Boolean {
    var isLetter: Boolean = false
    val expr = "^[A-Za-z]+$"
    if (this.matches(expr.toRegex())) {
        isLetter = true
    }
    return isLetter
}

/**
 * 描述：是否只是字母和数字.

 * @param str
 * *            指定的字符串
 * *
 * @return 是否只是字母和数字:是为true，否则false
 */
fun String.isNumberLetter(): Boolean {
    var isNoLetter: Boolean = false
    val expr = "^[A-Za-z0-9]+$"
    if (this.matches(expr.toRegex())) {
        isNoLetter = true
    }
    return isNoLetter
}
