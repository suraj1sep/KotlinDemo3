package com.cdat.fragments.dispansary_level

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
import java.util.*


/**
 * Created by SAM on 17-11-2018.
 */
class StrawDemandFragment : Fragment() {

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
        (activity as AppCompatActivity).supportActionBar!!.title = "Straw Demand"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_straw_demand, container, false)

        btn_add = view.findViewById<Button>(R.id.btn_add) as Button


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