package com.cdat.pre_login

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import com.cdat.R
import com.cdat.activity.HomeActivity
import com.cdat.contact_us.ContactUsFragment
import com.cdat.contact_us.TechnicalSupportFragment
import com.cdat.fragments.HomeFragment
import com.cdat.fragments.LoginFragment
import com.cdat.fragments.SignUpFragment
import com.cdat.helper.Config


class PreLoginDashbordFragment : Fragment() {

    private lateinit var llLogin: LinearLayout
    private lateinit var llRegistration: LinearLayout
    private lateinit var llContactUs: LinearLayout
    private lateinit var llTechSupport: LinearLayout
    private lateinit var llUsrManual: LinearLayout
    private var mLastClickTime: Long = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            //  ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(m_config.lbl_heading);
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_pre_login_dashboard, container, false)

        try {
            llLogin = rootView.findViewById<LinearLayout>(R.id.ll_login) as LinearLayout
            llRegistration = rootView.findViewById<LinearLayout>(R.id.ll_registration) as LinearLayout
            llContactUs = rootView.findViewById<LinearLayout>(R.id.ll_contactUs) as LinearLayout
            llTechSupport = rootView.findViewById<LinearLayout>(R.id.ll_techSupport) as LinearLayout
            llUsrManual = rootView.findViewById<LinearLayout>(R.id.ll_usrManual) as LinearLayout


            llLogin!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_up))
            llRegistration!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_down))
            llContactUs!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_up))
            llTechSupport!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_out_left))
            llUsrManual!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_up))



        } catch (e: Exception) {

        }

        llLogin!!.setOnClickListener {
            val loginFragment = LoginFragment()
            Config.slideFragment(loginFragment, "", fragmentManager!!, R.id.content_frame, "2")
        }
        llRegistration!!.setOnClickListener {
            val registrationFragment = SignUpFragment()
            Config.slideFragment(registrationFragment, "", fragmentManager!!, R.id.content_frame, "2")
        }
        llContactUs!!.setOnClickListener {
//            Toast.makeText(getActivity(), "Coming soon", Toast.LENGTH_SHORT).show();
            val contactusFragment = ContactUsFragment()
            Config.slideFragment(contactusFragment, "", fragmentManager!!, R.id.content_frame, "2")
        }
        llTechSupport!!.setOnClickListener {
//            Toast.makeText(getActivity(), "Coming soon", Toast.LENGTH_SHORT).show();
            val technicalsupFragment = TechnicalSupportFragment()
            Config.slideFragment(technicalsupFragment, "", fragmentManager!!, R.id.content_frame, "2")
        }
        llUsrManual!!.setOnClickListener {
            startActivity(Intent(activity, HomeActivity::class.java))
            activity!!.finish()
            activity!!.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        return rootView
    }

}
