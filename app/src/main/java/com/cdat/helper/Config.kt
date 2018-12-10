package com.cdat.helper

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.cdat.R


/**
 * Created by SAM
 */

object Config {

    /*This function is used for sliding fragment */
    fun slideFragment(fragment: Fragment, tag: String, fragmentTransaction: FragmentManager, frameId: Int, slideEnum: String) {

        val ft = fragmentTransaction.beginTransaction()
        // check slideEnum Type for slide Up, down,left and Right....
        when (slideEnum) {
            "1" -> ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down)
            "2" -> ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
            "4" -> ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left)
            else -> ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down)
        }

        val count = fragmentTransaction.backStackEntryCount
        if (count == 0) {
            ft.add(frameId, fragment, tag)
        } else {
            ft.replace(frameId, fragment, tag)
        }
        ft.addToBackStack(tag)
        //        ft.commit();
        ft.commitAllowingStateLoss()
    }

}
