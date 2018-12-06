package com.dairy.activity

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager

import com.dairy.R
import com.dairy.helper.SharePrefUtil
import com.dairy.helper.Utils

import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.dairy.pre_login.WelcomeActivity


class SplashActivity : AppCompatActivity() {

    private var sharePrefUtil: SharePrefUtil? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val ivLogo = findViewById(R.id.iv_splashLogo) as ImageView
        val tvAppName = findViewById(R.id.tv_appName) as TextView
        val tvSlogan = findViewById(R.id.tv_slogan) as TextView

        ivLogo.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in);
        tvAppName.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_left);
        tvSlogan.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_right);

        try {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
            sharePrefUtil = SharePrefUtil(applicationContext)
            goToHome()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun startApp() {
        if (Build.VERSION.SDK_INT >= 23
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.GET_ACCOUNTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.RECORD_AUDIO),
                    PERMISSION_REQUEST_CODE)
        } else {
            goToHome()
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.e("", "onRequestPermissionsResult: " + requestCode + " " + grantResults.size + " " + grantResults[0])
        when (requestCode) {

            PERMISSION_REQUEST_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PERMISSION_GRANTED) {
                    goToHome()
                } else {
                    Utils.customMessage(this@SplashActivity, "Please allow  permissions !")
                    finish()
                }
            }
        }
    }

    private fun goToHome() {

        Handler().postDelayed({
//            val mainIntent = Intent(this@SplashActivity, BackgroundActivity::class.java)
            val mainIntent = Intent(this@SplashActivity, WelcomeActivity::class.java)
            startActivity(mainIntent)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }, 5000)

    }

    companion object {
        private val PERMISSION_REQUEST_CODE = 25
    }
}
