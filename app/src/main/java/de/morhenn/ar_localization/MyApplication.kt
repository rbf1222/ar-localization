package de.morhenn.ar_localization

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

import android.app.Application

class MyApplication : Application() {

    companion object {
        @JvmField
        var initialized = false
        const val TAG = "ArLocalizationApp"
    }

    override fun onCreate() {
        super.onCreate()
        if (!initialized) {
            initialized = true
        }
    }
}