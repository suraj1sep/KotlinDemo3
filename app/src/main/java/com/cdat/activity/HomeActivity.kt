package com.cdat.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import com.cdat.R
import com.cdat.fragments.HomeFragment
import com.cdat.helper.Config
import com.cdat.fragments.profile.FarmerProfileFragment

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        private lateinit var toolbar: Toolbar
        private lateinit var drawer_layout: DrawerLayout
        private lateinit var nav_view: NavigationView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer_layout = findViewById<DrawerLayout>(R.id.drawer_layout)
        nav_view = findViewById<NavigationView>(R.id.nav_view)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val loginFrgment = HomeFragment()
        Config.slideFragment(loginFrgment, "", supportFragmentManager, R.id.content_frame, "2")

        val llPoweredBy = findViewById<LinearLayout>(R.id.ll_poweredBy)

        llPoweredBy.setOnClickListener {
            val uri = Uri.parse("http://c-dat.org")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            val mFragment = supportFragmentManager.findFragmentById(R.id.content_frame)
            if (mFragment is HomeFragment) {
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            } else {
                super.onBackPressed()
            }
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_my_order -> {
                val home_Frgment = HomeFragment()
                Config.slideFragment(home_Frgment, "", supportFragmentManager, R.id.content_frame, "2")
            }
            R.id.nav_my_cart -> {
//                Toast.makeText(this, "Coming Soon..", Toast.LENGTH_SHORT).show()
                val farmerPrfFrgment = FarmerProfileFragment()
                Config.slideFragment(farmerPrfFrgment, "", supportFragmentManager, R.id.content_frame, "2")
            }
            R.id.nav_track_order -> {
                Toast.makeText(this, "Coming Soon..", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_my_reward -> {
                Toast.makeText(this, "Coming Soon..", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_my_address -> {
                Toast.makeText(this, "Coming Soon..", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
