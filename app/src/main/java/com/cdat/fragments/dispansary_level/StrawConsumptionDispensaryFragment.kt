package com.cdat.fragments.dispansary_level

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cdat.R
import com.cdat.helper.Utils
import java.util.*


class StrawConsumptionDispensaryFragment : Fragment() {

    companion object {
        private lateinit var tv_village_name: TextView
        private lateinit var tv_farmer_name: TextView
        private lateinit var tv_animal_cate: TextView
        private lateinit var tv_animal_breed_category: TextView
        private lateinit var tv_breed_blood_level: TextView
        private lateinit var tv_pd_tested_date: TextView
        private lateinit var tv_date_calving: TextView

        private lateinit var iv_search_village: ImageView
        private lateinit var iv_search_farmer: ImageView

        private lateinit var et_search_farmer: EditText
        private lateinit var et_search_village: EditText

        private lateinit var sp_animal_ear_tag: Spinner
        private lateinit var sp_ai_date: Spinner
        private lateinit var sp_pd_result: Spinner

        private lateinit var btn_Distribute: Button

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Straw Consumption "
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_straw_consumption_dispensary, container, false)

       /* tv_village_name = view.findViewById<TextView>(R.id.tv_village_name) as TextView
        tv_farmer_name = view.findViewById<TextView>(R.id.tv_farmer_name) as TextView
        iv_search_village = view.findViewById<ImageView>(R.id.iv_search_village) as ImageView
        iv_search_farmer = view.findViewById<ImageView>(R.id.iv_search_farmer) as ImageView

        et_search_farmer = view.findViewById<EditText>(R.id.et_search_farmer) as EditText
        et_search_village = view.findViewById<EditText>(R.id.et_search_village) as EditText

        sp_animal_ear_tag = view.findViewById<Spinner>(R.id.sp_animal_ear_tag) as Spinner
        sp_ai_date = view.findViewById<Spinner>(R.id.sp_ai_date) as Spinner
        sp_pd_result = view.findViewById<Spinner>(R.id.sp_pd_result) as Spinner*/

        btn_Distribute = view.findViewById<Button>(R.id.btn_Distribute) as Button

        btn_Distribute.setOnClickListener {
            if (isValid())
                Utils.customMessage(this!!.context!!, "Added")
        }

        return view
    }

    @SuppressLint("NewApi")
    fun isValid(): Boolean {

        val production_date: String = tv_pd_tested_date.text.toString()

        if (production_date.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please select date !!")
            return false
        }
/*
        et_search_farmer
        et_search_village


        if (et_straw_used.text.toString().isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter no of Straw used!!")
            et_straw_used.requestFocus()
            return false
        }
        if (et_motility.text.toString().isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter motility result!!")
            et_motility.requestFocus()
            return false
        }*/

        return true
    }

}