package com.cdat

import android.content.Context
import android.content.pm.PackageManager
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatDelegate

/**
 * Created by SAM // 05-11-2018
 */

class AppController : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        mContext = this
        MultiDex.install(this)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        try {
            val pInfo = this.packageManager.getPackageInfo(packageName, 0)
            CURRENT_APP_VERSION = pInfo.versionName
            MY_DB_VERSION = pInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

    }

    companion object {
        val TAG = AppController::class.java.simpleName
        var s_no = "0"
        lateinit var mContext: Context
        var MY_DB_VERSION: Int = 0
        lateinit var CURRENT_APP_VERSION: String
    }
}
