package com.dairy.fragments

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
import com.dairy.R
import com.dairy.helper.Utils
import android.app.DatePickerDialog
import java.util.*


/**
 * Created by SAM on 17-11-2018.
 */
class BullRegisterFragment : Fragment() {

    companion object {
        private lateinit var tv_DOB: TextView
        private lateinit var tv_ProcurementDate: TextView
        private lateinit var et_mobile_no: EditText
        private lateinit var et_flat_no: EditText
        private lateinit var et_locality: EditText
        private lateinit var et_landmark: EditText
        private lateinit var et_city: EditText
        private lateinit var et_state: EditText
        private lateinit var et_pin_code: EditText

        private lateinit var btn_add: Button

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Bull Register"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register_bull, container, false)

        tv_DOB = view.findViewById<TextView>(R.id.tv_DOB) as TextView
        tv_ProcurementDate = view.findViewById<TextView>(R.id.tv_ProcurementDate) as TextView
//        et_mobile_no = view.findViewById<EditText>(R.id.et_mobile_no) as EditText
//        et_flat_no = view.findViewById<EditText>(R.id.et_flat_no) as EditText
//        et_locality = view.findViewById<EditText>(R.id.et_locality) as EditText
//        et_landmark = view.findViewById<EditText>(R.id.et_landmark) as EditText
//        et_city = view.findViewById<EditText>(R.id.et_city) as EditText
//        et_state = view.findViewById<EditText>(R.id.et_state) as EditText
//        et_pin_code = view.findViewById<EditText>(R.id.et_pin_code) as EditText

        btn_add = view.findViewById<Button>(R.id.btn_add) as Button

        tv_DOB.setOnClickListener {

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
                        tv_DOB.text = (day + "/" + month + "/" + year)
                    }, mYear, mMonth, mDay)
            datePickerDialog.datePicker.maxDate = Date().getTime()
            datePickerDialog.show()
        }

        tv_ProcurementDate.setOnClickListener {

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
                        tv_ProcurementDate.text = (day + "/" + month + "/" + year)
                    }, mYear, mMonth, mDay)
            datePickerDialog.datePicker.maxDate = Date().getTime()
            datePickerDialog.show()
        }

        btn_add.setOnClickListener {
            //            if (isValid())
//                Utils.customMessage(this!!.context!!, "Added")
        }

        return view
    }

    @SuppressLint("NewApi")
    fun isValid(): Boolean {

        val name: String = tv_DOB.text.toString()
        val mobile: String = et_mobile_no.text.toString()
        val flat: String = et_flat_no.text.toString()
        val locality: String = et_locality.text.toString()
        val city: String = et_city.text.toString()
        val state: String = et_state.text.toString()
        val pin: String = et_pin_code.text.toString()

        if (name.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter name !!")
            return false
        }
        if (mobile.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter mobile no !!")
            et_mobile_no.requestFocus()
            return false
        }
        if (flat.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter flat no or building name !!")
            et_flat_no.requestFocus()
            return false
        }
        if (locality.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter locality !!")
            et_locality.requestFocus()
            return false
        }
        if (city.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter city !!")
            et_city.requestFocus()
            return false
        }
        if (state.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter state !!")
            et_state.requestFocus()
            return false
        }
        if (pin.isEmpty()) {
            Utils.customMessage(this!!.context!!, "Please enter pin code !!")
            et_pin_code.requestFocus()
            return false
        }
        return true
    }

}