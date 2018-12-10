package com.cdat.pre_login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cdat.R;
import com.cdat.fragments.LoginFragment;
import com.cdat.fragments.SignUpFragment;
import com.cdat.helper.Config;


public class PreLoginDashbordFragment extends Fragment implements View.OnClickListener {

    private LinearLayout llLogin, llContactUs, llTechSupport, llUsrManual;
    private long mLastClickTime = 0;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            //  ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(m_config.lbl_heading);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pre_login_dashboard, container, false);

        try {
            llLogin = (LinearLayout) rootView.findViewById(R.id.ll_login);
            llContactUs = (LinearLayout) rootView.findViewById(R.id.ll_contactUs);
            llTechSupport = (LinearLayout) rootView.findViewById(R.id.ll_techSupport);
            llUsrManual = (LinearLayout) rootView.findViewById(R.id.ll_usrManual);

            final AnimatorSet mAnimationSet = new AnimatorSet();

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
            mAnimationSet.start();
            llLogin.setOnClickListener(this);
            llContactUs.setOnClickListener(this);
            llTechSupport.setOnClickListener(this);
            llUsrManual.setOnClickListener(this);

        } catch (Exception e) {

        }

        llLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SignUpFragment registerFragment = new SignUpFragment();
//                Config.slideFragment(registerFragment, "", getFragmentManager(), R.id.content_frame, "ankole")
            }
        });
        return rootView;
    }

    @Override
    public void onClick(View view) {

        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        try {
            switch (view.getId()) {

                case R.id.ll_login:

//                    BmiCalculatorFragment bmiCalFrag = new BmiCalculatorFragment();
//                    Config.slideFragment(bmiCalFrag, "", getFragmentManager(), R.id.fragment_placeholder, "2");
                    break;
                case R.id.ll_contactUs:
//                    BMRCalculatorFragment bmrCalculatorFragment = new BMRCalculatorFragment();
//                    Config.slideFragment(bmrCalculatorFragment, "", getFragmentManager(), R.id.fragment_placeholder, "2");
                    break;
                case R.id.ll_techSupport:
//                    PregnancyCalculatorFragment pregFrag = new PregnancyCalculatorFragment();
//                    Config.slideFragment(pregFrag, "", getFragmentManager(), R.id.fragment_placeholder, "2");
                    break;
                case R.id.ll_usrManual:
//                    FertilityCalculatorFragment fertilityCalFragment = new FertilityCalculatorFragment();
//                    Config.slideFragment(fertilityCalFragment, "", getFragmentManager(), R.id.fragment_placeholder, "2");
                    break;

                default:
                    break;

            }
        } catch (Exception e) {

        }
    }
}
