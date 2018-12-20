package com.cdat.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.cdat.R
import com.cdat.adapter.HomeMenuAdapter
import com.cdat.fragments.daic.AnnualStrawPlanListDAICFragment
import com.cdat.fragments.daic.MotilityStrawDAICFragment
import com.cdat.fragments.daic.ReceivedStrawDAICListFragment
import com.cdat.fragments.daic.StrawDistribitionListDAICFragment
import com.cdat.fragments.lab.AnnualStrawPlanListFragment
import com.cdat.fragments.lab.BullListFragment
import com.cdat.fragments.lab.StrawDistribitionListFragment
import com.cdat.fragments.lab.StrawProductionLabListFragment
import com.cdat.helper.AutoScrollViewPager
import com.cdat.helper.Config
import com.cdat.helper.DensityUtil
import com.cdat.helper.Utils
import com.cdat.profile.AnimalProfileFragment
import com.cdat.profile.AnimalProfileListFragment
import com.cdat.profile.FarmerProfileFragment

class HomeFragment : Fragment() {

    companion object {
        private lateinit var recyclerView: RecyclerView
        private lateinit var mPager: AutoScrollViewPager
        private lateinit var llIndexContainer: LinearLayout
        internal var sampleImages: IntArray? = intArrayOf(R.drawable.banner)
        private val categoryList: ArrayList<String> = ArrayList()
        lateinit var clickListener: HomeMenuAdapter.ClickListener

        var loginType: Int = 1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = getString(R.string.app_name)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        mPager = view.findViewById<AutoScrollViewPager>(R.id.carouselView2) as AutoScrollViewPager
        llIndexContainer = view.findViewById<LinearLayout>(R.id.ll_index_container) as LinearLayout

        loginType = Utils.loginType

        val mPagerAdapter = ScreenSlidePagerAdapter(childFragmentManager)
        mPager.startAutoScroll()
        mPager.setInterval(3000)
        mPager.setCycle(true)
        mPager.setAdapter(mPagerAdapter)
        addIndicatorImageViews()
        setViewPagerChangeListener()

        categoryList.clear()
        if (loginType == 1) {
            categoryList.add("Bull Registration")
            categoryList.add("Straw Plan")
            categoryList.add("Straw Production")
            categoryList.add("Straw Distribution")
        } else if (loginType == 2) {
            categoryList.add("Straw Plan")
            categoryList.add("Straw Received")
            categoryList.add("Straw Distribution")
            categoryList.add("Straw Motility")
        } else if (loginType == 3) {
            categoryList.add("Straw Plan")
            categoryList.add("Straw Received")
            categoryList.add("Straw Distribution")
            categoryList.add("Straw Motility")
        } else if (loginType == 4) {
            categoryList.add("Farmer Profile")
            categoryList.add("Animal Profile")
//            categoryList.add("Straw Plan")
//            categoryList.add("Straw Received")
//            categoryList.add("Straw Distribution")
//            categoryList.add("Straw Motility")
        }

        clickListener = object : HomeMenuAdapter.ClickListener {

            override fun click(position: Int) {
                if (loginType == 1)
                    if (position == 0) {
                        var registerFragment = BullListFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 1) {
                        var registerFragment = AnnualStrawPlanListFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 2) {
                        var registerFragment = StrawProductionLabListFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 3) {
                        var registerFragment = StrawDistribitionListFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else
                        Utils.customMessage(activity!!, "Coming soon!!")
                else if (loginType == 2)
                    if (position == 0) {
                        var registerFragment = AnnualStrawPlanListDAICFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 1) {
                        var registerFragment = ReceivedStrawDAICListFragment()
                          Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 2) {
                        var registerFragment = StrawDistribitionListDAICFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 3) {
                        var registerFragment = MotilityStrawDAICFragment()
                           Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else
                        Utils.customMessage(activity!!, "Coming soon!!")
                else if (loginType == 3)
                    if (position == 0) {
                        var registerFragment = BullListFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 1) {
                        var registerFragment = AnnualStrawPlanListFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 2) {
                        var registerFragment = StrawProductionLabListFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 3) {
                        var registerFragment = StrawDistribitionListFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else
                        Utils.customMessage(activity!!, "Coming soon!!")
                else if (loginType == 4)
                    if (position == 0) {
                        var registerFragment = FarmerProfileFragment()
                        Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
                    } else if (position == 1) {
                        var animalFragment = AnimalProfileListFragment()
                        Config.slideFragment(animalFragment, "", fragmentManager!!, R.id.content_frame, "2")

                    } else
                        Utils.customMessage(activity!!, "Coming soon!!")
            }

        }
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(activity, 2) as RecyclerView.LayoutManager?
        recyclerView.adapter = HomeMenuAdapter(this!!.activity!!, categoryList, clickListener)
        return view
    }

    private fun addIndicatorImageViews() {
        llIndexContainer.removeAllViews()

        for (i in sampleImages!!.indices) {
            val iv = ImageView(activity)
            val lp = LinearLayout.LayoutParams(DensityUtil.dip2px(activity, 5F), DensityUtil.dip2px(activity, 5F))
            lp.leftMargin = DensityUtil.dip2px(activity, if (i == 0) 0F else 7F)
            iv.layoutParams = lp
            iv.setBackgroundResource(R.drawable.xml_round_orange_grey_sel)
            iv.isEnabled = i == 0
            llIndexContainer.addView(iv)
        }

    }

    private fun setViewPagerChangeListener() {
        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                if (sampleImages == null || sampleImages!!.size == 0) return
                val newPosition = position % sampleImages!!.size
                for (i in sampleImages!!.indices) {
                    llIndexContainer.getChildAt(i).setEnabled(i == newPosition)
                }
            }

            override fun onPageScrolled(position: Int, arg1: Float, arg2: Int) {}

            override fun onPageScrollStateChanged(arg0: Int) {}
        })
    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return ScreenSlidePageFragment.newInstance(sampleImages!![position])
        }

        override fun getCount(): Int {
            return sampleImages!!.size
        }

    }

    @SuppressLint("ValidFragment")
    class ScreenSlidePageFragment @SuppressLint("ValidFragment") constructor
    (private val sampleImage: Int) : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(
                    R.layout.item_home, container, false) as ViewGroup
            val imageView = rootView.findViewById<ImageView>(R.id.iv_img)
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            imageView.setLayoutParams(params)
            imageView.setImageResource(sampleImage)
            imageView.setScaleType(ImageView.ScaleType.FIT_XY)

            return rootView
        }

        companion object {

            fun newInstance(sampleImage: Int): Fragment {
                return ScreenSlidePageFragment(sampleImage)
            }
        }
    }


}// Required empty public constructor


