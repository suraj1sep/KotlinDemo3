package com.cdat.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.cdat.R
import com.cdat.fragments.HomeFragment
import com.cdat.helper.Config

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
        Config.slideFragment(loginFrgment, "", supportFragmentManager, R.id.content_frame, "ankole")
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
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
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_my_order -> {
//                val loginFrgment = MyOrderListFragment()
//                Config.slideFragment(loginFrgment, "", supportFragmentManager, R.id.content_frame, "ankole")
            }
            R.id.nav_my_cart -> {
//                val loginFrgment = MyCartListFragment()
//                Config.slideFragment(loginFrgment, "", supportFragmentManager, R.id.content_frame, "ankole")
            }
            R.id.nav_track_order -> {

            }
            R.id.nav_my_reward -> {

            }
            R.id.nav_my_address -> {
//                var addressListFragment = AddressListFragment()
//                Config.slideFragment(addressListFragment, "", supportFragmentManager, R.id.content_frame, "ankole")
            }
            R.id.nav_logout -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
