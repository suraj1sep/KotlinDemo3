package com.cdat.helper

import android.content.Context
import android.content.SharedPreferences

class SharePrefUtil(private val context: Context) {
    private val prefs: SharedPreferences = this.context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)


    fun setValueInSharePref(keyName: String, value: String) {
        prefs.edit().putString(keyName, value).apply()
    }

    fun getValueFromSharePref(keyName: String): String {
        return prefs.getString(keyName, "")
    }
}
