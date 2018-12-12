package com.cdat.pre_login

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import com.cdat.R
import com.cdat.activity.HomeActivity
import com.cdat.fragments.HomeFragment
import com.cdat.fragments.LoginFragment
import com.cdat.helper.Config


class PreLoginDashbordFragment : Fragment(), View.OnClickListener {

    private lateinit var llLogin: LinearLayout
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
            llContactUs = rootView.findViewById<LinearLayout>(R.id.ll_contactUs) as LinearLayout
            llTechSupport = rootView.findViewById<LinearLayout>(R.id.ll_techSupport) as LinearLayout
            llUsrManual = rootView.findViewById<LinearLayout>(R.id.ll_usrManual) as LinearLayout


            llLogin!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_left))
            llContactUs!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_right))
            llTechSupport!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_left))
            llUsrManual!!.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_right))

            /* final AnimatorSet mAnimationSet = new AnimatorSet();

            ObjectAnimator moveY_tl_otp = ObjectAnimator.ofFloat(llLogin, "translationX", -1500f, 0);
            moveY_tl_otp.setDuration(1500);

            ObjectAnimator moveY_tl_otp2 = ObjectAnimator.ofFloat(llContactUs, "translationX", 1500f, 0);
            moveY_tl_otp2.setDuration(1500);

            ObjectAnimator moveY_tl_otp3 = ObjectAnimator.ofFloat(llTechSupport, "translationX", -1500f, 0);
            moveY_tl_otp3.setDuration(1500);

            ObjectAnimator moveY_tl_otp4 = ObjectAnimator.ofFloat(llUsrManual, "translationX", 1500f, 0);
            moveY_tl_otp4.setDuration(1500);

            mAnimationSet.play(moveY_tl_otp);
            mAnimationSet.play(moveY_tl_otp2);
            mAnimationSet.play(moveY_tl_otp3);
            mAnimationSet.play(moveY_tl_otp4);
            mAnimationSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                }
            });
            mAnimationSet.start();*/



        } catch (e: Exception) {

        }

        llLogin!!.setOnClickListener {
            val loginFragment = LoginFragment()
            Config.slideFragment(loginFragment, "", fragmentManager!!, R.id.content_frame, "2")
        }
        llContactUs!!.setOnClickListener {
            Toast.makeText(getActivity(), "Coming soon", Toast.LENGTH_SHORT).show();
        }
        llTechSupport!!.setOnClickListener {
            Toast.makeText(getActivity(), "Coming soon", Toast.LENGTH_SHORT).show();
        }
        llUsrManual!!.setOnClickListener {
            startActivity(Intent(activity, HomeActivity::class.java))
            activity!!.finish()
            activity!!.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        return rootView
    }

    override fun onClick(view: View) {

        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return
        }
        mLastClickTime = SystemClock.elapsedRealtime()
        try {
            when (view.id) {

                R.id.ll_login -> {

//                    fragmentManager!!.popBackStack()
                    val loginFragment = LoginFragment()
                    Config.slideFragment(loginFragment, "", fragmentManager!!, R.id.content_frame, "2")
                }
                R.id.ll_contactUs -> {
                }
                R.id.ll_techSupport -> {

                }
                R.id.ll_usrManual -> {
//                    fragmentManager!!.popBackStack()
                    val homeFragment = HomeFragment()
                    Config.slideFragment(homeFragment, "", fragmentManager!!, R.id.content_frame, "2")
                }

                else -> {
                }
            }//                    BmiCalculatorFragment bmiCalFrag = new BmiCalculatorFragment();
            //                    Config.slideFragment(bmiCalFrag, "", getFragmentManager(), R.id.fragment_placeholder, "2");
            //                    BMRCalculatorFragment bmrCalculatorFragment = new BMRCalculatorFragment();
            //                    Config.slideFragment(bmrCalculatorFragment, "", getFragmentManager(), R.id.fragment_placeholder, "2");
            //                    PregnancyCalculatorFragment pregFrag = new PregnancyCalculatorFragment();
            //                    Config.slideFragment(pregFrag, "", getFragmentManager(), R.id.fragment_placeholder, "2");
            //                    FertilityCalculatorFragment fertilityCalFragment = new FertilityCalculatorFragment();
            //                    Config.slideFragment(fertilityCalFragment, "", getFragmentManager(), R.id.fragment_placeholder, "2");
        } catch (e: Exception) {

        }

    }
}
