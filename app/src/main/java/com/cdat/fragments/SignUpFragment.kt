package com.cdat.fragments

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

import com.cdat.R
import com.cdat.helper.Config
import com.cdat.helper.Utils

class SignUpFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        var et_fname = view.findViewById<TextInputEditText>(R.id.et_fname)
        var et_mname = view.findViewById<TextInputEditText>(R.id.et_mname)
        var et_lname = view.findViewById<TextInputEditText>(R.id.et_lname)
        var et_mobile_no = view.findViewById<TextInputEditText>(R.id.et_mobile_no)
        var et_email = view.findViewById<TextInputEditText>(R.id.et_email)
        var et_address = view.findViewById<TextInputEditText>(R.id.et_address)
        var sp_distric = view.findViewById<Spinner>(R.id.sp_distric)
        var sp_taluka = view.findViewById<Spinner>(R.id.sp_taluka)
        var sp_village = view.findViewById<Spinner>(R.id.sp_village)
        var et_user_name = view.findViewById<TextInputEditText>(R.id.et_user_name)
        var et_password = view.findViewById<TextInputEditText>(R.id.et_password)
        var et_confirm_password = view.findViewById<TextInputEditText>(R.id.et_confirm_password)

        var btn_sign_up = view.findViewById<Button>(R.id.btn_sign_up)
        var tv_already_account = view.findViewById<TextView>(R.id.tv_already_account)

        btn_sign_up.setOnClickListener(View.OnClickListener {
            Utils.customMessage(activity!!, "sign up successful")
        })

        tv_already_account.setOnClickListener(View.OnClickListener {
            fragmentManager!!.popBackStack()
            val registerFragment = LoginFragment()
            Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
        })

        return view
    }

    companion object {
        private val TAG = SignUpFragment::class.java.simpleName
    }

}
