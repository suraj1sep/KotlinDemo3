package com.cdat.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.cdat.R
import com.cdat.helper.Utils
import android.app.DatePickerDialog
import android.widget.Spinner
import java.util.*


/**
 * Created by SAM on 17-11-2018.
 */
class StrawDistributionFragment : Fragment() {

    companion object {
        private lateinit var tv_Production_Date: TextView

        private lateinit var et_batch_no: EditText
        private lateinit var et_pt_bull_test: EditText
        private lateinit var et_straw_produced_no: EditText
        private lateinit var et_agency_name: EditText

        private lateinit var sp_animal_cate: Spinner
        private lateinit var sp_breed_blood_level: Spinner
        private lateinit var sp_bluu_reg_no: Spinner

        private lateinit var btn_add: Button

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Add STRAW Purchase"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_production_add, container, false)

        tv_Production_Date = view.findViewById<TextView>(R.id.tv_Production_Date) as TextView

        et_batch_no = view.findViewById<EditText>(R.id.et_batch_no) as EditText
        et_pt_bull_test = view.findViewById<EditText>(R.id.et_pt_bull_test) as EditText
        et_straw_produced_no = view.findViewById<EditText>(R.id.et_straw_produced_no) as EditText
        et_agency_name = view.findViewById<EditText>(R.id.et_agency_name) as EditText

        sp_animal_cate = view.findViewById<Spinner>(R.id.sp_animal_cate) as Spinner
        sp_breed_blood_level = view.findViewById<Spinner>(R.id.sp_breed_blood_level) as Spinner
        sp_bluu_reg_no = view.findViewById<Spinner>(R.id.sp_bluu_reg_no) as Spinner

        btn_add = view.findViewById<Button>(R.id.btn_add) as Button

        tv_Production_Date.setOnClickListener {

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
                        tv_Production_Date.text = (day + "/" + month + "/" + year)
                    }, mYear, mMonth, mDay)
            datePickerDialog.datePicker.maxDate = Date().getTime()
            datePickerDialog.show()
        }



        btn_add.setOnClickListener {
            if (isValid())
                Utils.customMessage(this!!.context!!, "Added")
        }

        return view
    }

    @SuppressLint("NewApi")
    fun isValid(): Boolean {

        val production_date: String = tv_Production_Date.text.toString()

        if (production_date.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please select date !!")
            return false
        }

        if (et_batch_no.text.toString().isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter batch no!!")
            et_batch_no.requestFocus()
            return false
        }

        if (et_pt_bull_test.text.toString().isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter P. T. bull test!!")
            et_pt_bull_test.requestFocus()
            return false
        }
        if (et_straw_produced_no.text.toString().isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter STRAWS produced no!!")
            et_straw_produced_no.requestFocus()
            return false
        }
        if (et_agency_name.text.toString().isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter agency name!!")
            et_agency_name.requestFocus()
            return false
        }

        return true
    }

}