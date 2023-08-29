package de.morhenn.ar_localization.utils

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

import android.util.Log

object TimingUtil {

    private const val TAG = "TimingUtil"

    fun <T> runTimed(name: String, block: () -> T): T {
        val start = System.currentTimeMillis()
        val result = block.invoke()
        val end = System.currentTimeMillis()
        val execTime = end - start
        Log.d(TAG, "$execTime ms exec for $name")
        return result
    }

    fun timeInterim(name: String, start: Long) {
        val end = System.currentTimeMillis()
        val execTime = end - start
        Log.d(TAG, ":$execTime ms interim for $name")
    }
}