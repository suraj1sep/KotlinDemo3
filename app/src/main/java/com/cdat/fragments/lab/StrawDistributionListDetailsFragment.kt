package com.cdat.fragments.lab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.cdat.R


/**
 * Created by SAM on 17-11-2018.
 */
class StrawDistributionListDetailsFragment : Fragment() {

    companion object {
        private lateinit var ll_demand: LinearLayout

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Straw Distribution List Details"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_straw_distribution_list_details, container, false)
        ll_demand = view.findViewById<LinearLayout>(R.id.ll_demand)


        try {
            ll_demand.removeAllViews()
        } catch (e: Exception) {
        }
        for (i in 0..4) {
            val inflater = getLayoutInflater()
            val mView = inflater.inflate(R.layout.item_straw_distribute, null)
            var tv_date: TextView = mView.findViewById<TextView>(R.id.tv_date) as TextView
            var tv_straw: TextView = mView.findViewById<TextView>(R.id.tv_straw) as TextView
            ll_demand.addView(mView)
        }


        return view
    }


}