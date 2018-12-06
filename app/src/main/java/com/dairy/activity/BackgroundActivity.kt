package com.dairy.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.view.MenuItem
import android.widget.LinearLayout

import com.dairy.R
import com.dairy.fragments.LoginFragment
import com.dairy.helper.Config
import com.dairy.helper.SharePrefUtil


class BackgroundActivity : AppCompatActivity() {
    private var mFragment: Fragment? = null
    private val healthTips: LinearLayout? = null
    private val healthTools: LinearLayout? = null
    private val homeRemedies: LinearLayout? = null
    private val myFitness: LinearLayout? = null
    private val sharePrefUtil: SharePrefUtil? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)


        val loginFrgment = LoginFragment()
        Config.slideFragment(loginFrgment, "", supportFragmentManager, R.id.content_frame, "ankole")

    }

    override fun onBackPressed() {
        mFragment = supportFragmentManager.findFragmentById(R.id.content_frame)
        if (mFragment is LoginFragment) {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> {
                val count = supportFragmentManager.backStackEntryCount
                if (count <= 1) {
                    finish()
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                } else {
                    supportFragmentManager.popBackStack()
                }
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        var text: Spannable? = null
    }


}