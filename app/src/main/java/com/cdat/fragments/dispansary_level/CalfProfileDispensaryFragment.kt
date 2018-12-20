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


/**
 * Created by SAM on 17-11-2018.
 */
class CalfProfileDispensaryFragment : Fragment() {

    companion object {
        private lateinit var tv_village_name: TextView
        private lateinit var tv_farmer_name: TextView
        private lateinit var tv_calf_dob: TextView
        private lateinit var tv_calf_parent: TextView
        private lateinit var tv_add_photo: TextView

        private lateinit var iv_search_village: ImageView
        private lateinit var iv_search_farmer: ImageView
        private lateinit var iv_calf_photo: ImageView

        private lateinit var et_search_farmer: EditText
        private lateinit var et_search_village: EditText

        private lateinit var sp_animal_ear_tag: Spinner
        private lateinit var sp_calf_gender: Spinner

        private lateinit var et_calf_weight: EditText
        private lateinit var btn_Distribute: Button

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Calf Profile "
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_calf_profile, container, false)

        tv_village_name = view.findViewById<TextView>(R.id.tv_village_name) as TextView
        tv_farmer_name = view.findViewById<TextView>(R.id.tv_farmer_name) as TextView
        tv_calf_dob = view.findViewById<TextView>(R.id.tv_calf_dob) as TextView
        tv_calf_parent = view.findViewById<TextView>(R.id.tv_calf_parent) as TextView
        tv_add_photo = view.findViewById<TextView>(R.id.tv_add_photo) as TextView

        iv_search_village = view.findViewById<ImageView>(R.id.iv_search_village) as ImageView
        iv_search_farmer = view.findViewById<ImageView>(R.id.iv_search_farmer) as ImageView
        iv_calf_photo = view.findViewById<ImageView>(R.id.iv_calf_photo) as ImageView

        et_search_farmer = view.findViewById<EditText>(R.id.et_search_farmer) as EditText
        et_search_village = view.findViewById<EditText>(R.id.et_search_village) as EditText

        sp_animal_ear_tag = view.findViewById<Spinner>(R.id.sp_animal_ear_tag) as Spinner
        sp_calf_gender = view.findViewById<Spinner>(R.id.sp_calf_gender) as Spinner

        et_calf_weight = view.findViewById<EditText>(R.id.et_calf_weight) as EditText
        btn_Distribute = view.findViewById<Button>(R.id.btn_Distribute) as Button

        tv_calf_dob.setOnClickListener {

            val c = Calendar.getInstance()
            val mYear = c.get(Calendar.YEAR) // current year
            val mMonth = c.get(Calendar.MONTH) // current month
            val mDay = c.get(Calendar.DAY_OF_MONTH) // current day
            // date picker dialog
            val datePickerDialog = DatePickerDialog(activity!!,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        var monthOfYear = monthOfYear
                        // set day of month , month and year value in the edit text
                        var day: String? = null
                        var month: String? = null
                        if (dayOfMonth < 10) {
                            day = "0$dayOfMonth"
                        } else {
                            day = "" + dayOfMonth
                        }
                        monthOfYear += 1
                        if (monthOfYear < 10) {
                            month = "0$monthOfYear"
                        } else {
                            month = "" + monthOfYear
                        }
                        tv_calf_dob.text = (day + "/" + month + "/" + year)
                    }, mYear, mMonth, mDay)
            datePickerDialog.datePicker.maxDate = Date().getTime()
            datePickerDialog.show()
        }


        btn_Distribute.setOnClickListener {
            if (isValid())
                Utils.customMessage(this!!.context!!, "Added")
        }

        return view
    }

    @SuppressLint("NewApi")
    fun isValid(): Boolean {

        val production_date: String = tv_calf_dob.text.toString()

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