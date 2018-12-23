package com.cdat.fragments.lab

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
        private lateinit var tv_supply_date: TextView

        private lateinit var et_straw_supply_no: EditText

        private lateinit var sp_animal_cate: Spinner
        private lateinit var sp_breed_blood_level: Spinner
        private lateinit var sp_bull_reg_no: Spinner
        private lateinit var sp_Batch_Number: Spinner
        private lateinit var sp_daic_name: Spinner

        private lateinit var btn_Distribute: Button

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Straw Distribution sss"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_distribution, container, false)

        tv_supply_date = view.findViewById<TextView>(R.id.tv_supply_date) as TextView

        et_straw_supply_no = view.findViewById<EditText>(R.id.et_straw_supply_no) as EditText

        sp_animal_cate = view.findViewById<Spinner>(R.id.sp_animal_cate) as Spinner
        sp_breed_blood_level = view.findViewById<Spinner>(R.id.sp_breed_blood_level) as Spinner
        sp_bull_reg_no = view.findViewById<Spinner>(R.id.sp_bull_reg_no) as Spinner
        sp_Batch_Number = view.findViewById<Spinner>(R.id.sp_Batch_Number) as Spinner
        sp_daic_name = view.findViewById<Spinner>(R.id.sp_daic_name) as Spinner

        btn_Distribute = view.findViewById<Button>(R.id.btn_Distribute) as Button

        tv_supply_date.setOnClickListener {

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
                        tv_supply_date.text = (day + "/" + month + "/" + year)
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

        val production_date: String = tv_supply_date.text.toString()

        if (production_date.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please select date !!")
            return false
        }

        if (et_straw_supply_no.text.toString().isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter no of supply Straw!!")
            et_straw_supply_no.requestFocus()
            return false
        }

        return true
    }

}