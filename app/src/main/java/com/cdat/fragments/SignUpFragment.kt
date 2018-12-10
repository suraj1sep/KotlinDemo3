package com.cdat.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

import com.cdat.R
import com.cdat.helper.Config
import com.cdat.helper.Utils

class SignUpFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

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
