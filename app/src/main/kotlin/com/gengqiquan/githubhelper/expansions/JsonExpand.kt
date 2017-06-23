package com.sunshine.utillibrary.expand;

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception

/**
 * Created by gengqiquan on 2017/5/25.
 */


fun <T> String.fromJson(typeToken: TypeToken<List<T>>): List<T>? {
    var list: List<T>? = null
    try {
        list = Gson().fromJson<List<T>>(this, typeToken.type)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return list
}

fun <T> String.fromJson(clazz: Class<T>): T? {
    var bean: T? = null
    try {
        bean = Gson().fromJson(this, clazz)
    } catch (e: JsonSyntaxException) {
        e.printStackTrace()
    }
    return bean

}

/**
 * 描述：将对象转化为json.

 * @return
 */
fun Any.toJson(): String? {
    var json: String? = null
    try {
        json = Gson().toJson(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return json
}


fun String.getBoolean(key: String): Boolean {
    var value = false
    try {
        val obj = JSONObject(this)
        value = obj.optBoolean(key)
    } catch (e: JSONException) {
    }

    return value
}

/**
 * 描述：将String转化为JSONObject.

 * *
 * @return
 */
fun String.toJSONObject(): JSONObject? {
    var json: JSONObject? = null
    try {
        json = JSONObject(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return json
}

/**
 * 描述：将String转化为JSONArray.

 * *
 * @return
 */
fun String.toJSONArray(): JSONArray? {
    var json: JSONArray? = null
    try {
        json = JSONArray(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return json
}

/**
 * 描述：根据key取值

 * *
 * @return
 */
fun String.getObject(key: String): Any? {
    var str: Any? = null
    try {
        val obj = JSONObject(this)
        str = obj.get(key)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return str
}

/**
 * 描述：根据key值获取String.

 * @return
 */
fun String.getString(key: String): String? {
    var value: String? = null
    try {
        val obj = JSONObject(this)
        value = obj.getString(key)
    } catch (e: JSONException) {
    }

    return value
}

/**
 * 描述：根据key值获取Integer.

 * @return
 */
fun String.getInt(key: String): Int {
    var value: Int = -1
    try {
        val obj = JSONObject(this)
        value = obj.getInt(key)
    } catch (e: JSONException) {
    }

    return value
}

/**
 * 描述：根据key值获取Double.

 * @return
 */
fun String.getDouble(key: String): Double? {
    var value: Double? = null
    try {
        val obj = JSONObject(this)
        value = obj.getDouble(key)
    } catch (e: JSONException) {
    }

    return value
}
