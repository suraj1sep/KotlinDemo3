package com.dairy.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.dairy.R
import com.dairy.activity.BackgroundActivity
import com.dairy.activity.HomeActivity
import com.dairy.helper.Config
import com.dairy.helper.Utils
import com.dairy.services.request.GetVendorNameCityREQ
import com.dairy.services.response.GetInsuranceCompResponse
import com.dairy.services.response.GetVendorNameLogoNearByResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.gson.GsonBuilder


class LoginFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        var btn_sign_in = view.findViewById<Button>(R.id.btn_sign_in)
        var tv_create_account = view.findViewById<TextView>(R.id.tv_create_account)
        var tv_forgotPass = view.findViewById<TextView>(R.id.tv_forgotPass)

        btn_sign_in.setOnClickListener(View.OnClickListener {
            Utils.customMessage(activity!!, "login successful")
            startActivity(Intent(activity, HomeActivity::class.java))
            activity!!.finish()
            activity!!.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        })

        tv_create_account.setOnClickListener(View.OnClickListener {
            fragmentManager!!.popBackStack()
            val registerFragment = SignUpFragment()
            Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "ankole")
        })
        tv_forgotPass.setOnClickListener(View.OnClickListener {
            Utils.customMessage(activity!!, "forgot password")
        })
//        getListOfInsuranceMaster2()
        return view
    }

    companion object {
        private val TAG = LoginFragment::class.java.simpleName
    }

    private fun getListOfInsuranceMaster() {
        var call: Call<GetInsuranceCompResponse>? = null
        call = Utils.getWebService().getListOfInsuranceMaster()
        call.enqueue(object : Callback<GetInsuranceCompResponse> {
            override fun onResponse(call: Call<GetInsuranceCompResponse>, response: Response<GetInsuranceCompResponse>) {
                Log.e("TAg Yo", "onResponse: " + GsonBuilder().create().toJson(response.body()))
            }

            override fun onFailure(call: Call<GetInsuranceCompResponse>, t: Throwable) {
                Log.e("fail", t.message)
            }
        })
    }

    private fun getListOfInsuranceMaster2() {
        val specialityNearByRequest = GetVendorNameCityREQ()
        specialityNearByRequest.setVendorCatID(2)

        var call: Call<GetVendorNameLogoNearByResponse>? = null
        call = Utils.getWebService().GetVendorNameLogoNearBy(specialityNearByRequest)
        call.enqueue(object : Callback<GetVendorNameLogoNearByResponse> {
            override fun onResponse(call: Call<GetVendorNameLogoNearByResponse>, response: Response<GetVendorNameLogoNearByResponse>) {
                Log.e("TAg Yo", "onResponse: " + GsonBuilder().create().toJson(response.body()))
            }

            override fun onFailure(call: Call<GetVendorNameLogoNearByResponse>, t: Throwable) {
                Log.e("fail", t.message)
            }
        })
    }
}
