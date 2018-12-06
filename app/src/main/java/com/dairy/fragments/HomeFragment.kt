package com.dairy.fragments

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
import android.widget.Switch
import com.dairy.R
import com.dairy.adapter.HomeMenuAdapter
import com.dairy.helper.AutoScrollViewPager
import com.dairy.helper.Config
import com.dairy.helper.DensityUtil
import com.dairy.helper.Utils

class HomeFragment : Fragment() {

    companion object {
        private lateinit var recyclerView: RecyclerView
        private lateinit var mPager: AutoScrollViewPager
        private lateinit var llIndexContainer: LinearLayout
//        internal var sampleImages: IntArray? = intArrayOf(R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner1)
        internal var sampleImages: IntArray? = intArrayOf(R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo)
        private val categoryList: ArrayList<String> = ArrayList()
        lateinit var clickListener: HomeMenuAdapter.ClickListener
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

        val mPagerAdapter = ScreenSlidePagerAdapter(childFragmentManager)
        mPager.startAutoScroll()
        mPager.setInterval(3000)
        mPager.setCycle(true)
        mPager.setAdapter(mPagerAdapter)
        addIndicatorImageViews()
        setViewPagerChangeListener()

        categoryList.clear()
        categoryList.add("Bull")
        categoryList.add("STRAW Plan")
        categoryList.add("Production")
        categoryList.add("Purchase STRAW")
        categoryList.add("STRAW Distribution")
        categoryList.add(" ")


        clickListener = object : HomeMenuAdapter.ClickListener {

            override fun click(position: Int) {
                if (position == 0) {
                    var registerFragment = BullListFragment()
                    Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "ankole")
                } else if (position == 1) {
                    var registerFragment = AnnualStrawPlanListFragment()
                    Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "ankole")
                 } else if (position == 2) {
                    var registerFragment = ProductionLabListFragment()
                    Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "ankole")
                } else
                    Utils.customMessage(activity!!, "Coming soon!!")
            }

        }
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView
        if (categoryList.size <= 5)
            recyclerView.layoutManager = GridLayoutManager(activity, 1)
        else
            recyclerView.layoutManager = GridLayoutManager(activity, 2)
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
