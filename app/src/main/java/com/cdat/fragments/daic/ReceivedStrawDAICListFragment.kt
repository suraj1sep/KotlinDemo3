package com.cdat.fragments.daic

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import com.cdat.R
import com.cdat.adapter.daic.ReceivedStrawDAICListAdapter
import com.cdat.helper.Config


/**
 * Created by SAM on 17-11-2018.
 */
class ReceivedStrawDAICListFragment : Fragment() {

    companion object {
        private lateinit var recyclerView: RecyclerView
        private lateinit var et_search: EditText
        private val categoryList: ArrayList<String> = ArrayList()
        lateinit var manageCart: ReceivedStrawDAICListAdapter.ManageCart
        public var searchText: String = ""

        private lateinit var tv_year: TextView
        lateinit var fab_add: FloatingActionButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Straw Received "
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_received_straw_daic, container, false)

        et_search = view.findViewById(R.id.et_search) as EditText
        recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        tv_year = view.findViewById(R.id.tv_year) as TextView
        fab_add = view.findViewById(R.id.fab_add) as FloatingActionButton

        tv_year.setOnClickListener {
            selectYear()
        }

        fab_add.setOnClickListener {
            val registerFragment = ReceivedStrawDAICFragment()
            Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "2")
        }


        manageCart = object : ReceivedStrawDAICListAdapter.ManageCart {
            override fun cart() {
            }
        }
        init()
        //item_annual_straw_plan_lab

        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        var adapter1 = ReceivedStrawDAICListAdapter(this!!.activity!!, categoryList, manageCart)
        recyclerView.adapter = adapter1

        et_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                searchText = et_search.getText().toString().toLowerCase()
                if (adapter1 != null)
                    adapter1.getFilter().filter(searchText)
            }
        })
        return view
    }

    private fun init() {
        categoryList.add("Milk")
    }

    private fun selectYear() {
        val builder1 = AlertDialog.Builder(activity!!)
        val inflater = layoutInflater
        val mView = inflater.inflate(R.layout.frame_date_picker, null)

        val dp_mes = mView.findViewById(R.id.datePicker) as DatePicker
        builder1.setView(mView)


        val year = dp_mes.year
        val month = dp_mes.month
        val day = dp_mes.dayOfMonth

        dp_mes.calendarViewShown = false
        dp_mes.spinnersShown = true

        val month_i = IntArray(1)
        dp_mes.init(year, month, day) { view, year, monthOfYear, dayOfMonth ->
            month_i[0] = year
            Log.e("selected month:", Integer.toString(month_i[0]))
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android")
            if (daySpinnerId != 0) {
                val daySpinner = dp_mes.findViewById<View>(daySpinnerId)
                if (daySpinner != null) {
                    daySpinner.visibility = View.GONE
                }
            }

            val monthSpinnerId = Resources.getSystem().getIdentifier("month", "id", "android")
            if (monthSpinnerId != 0) {
                val monthSpinner = dp_mes.findViewById<View>(monthSpinnerId)
                if (monthSpinner != null) {
                    monthSpinner.visibility = View.GONE
                }
            }

            val yearSpinnerId = Resources.getSystem().getIdentifier("year", "id", "android")
            if (yearSpinnerId != 0) {
                val yearSpinner = dp_mes.findViewById<View>(yearSpinnerId)
                if (yearSpinner != null) {
                    yearSpinner.visibility = View.VISIBLE
                }
            }
        } else { //Older SDK versions
            val f = dp_mes.javaClass.declaredFields
            for (field in f) {
                if (field.name.equals("mDayPicker") || field.name.equals("mDaySpinner")) {
                    field.isAccessible = true
                    var dayPicker: Any? = null
                    try {
                        dayPicker = field.get(dp_mes)
                    } catch (e: IllegalAccessException) {
                        e.printStackTrace()
                    }

                    (dayPicker as View).visibility = View.GONE
                }

                if (field.name.equals("mMonthPicker") || field.name.equals("mMonthSpinner")) {
                    field.isAccessible = true
                    var monthPicker: Any? = null
                    try {
                        monthPicker = field.get(dp_mes)
                    } catch (e: IllegalAccessException) {
                        e.printStackTrace()
                    }

                    (monthPicker as View).visibility = View.GONE
                }

                if (field.name.equals("mYearPicker") || field.name.equals("mYearSpinner")) {
                    field.isAccessible = true
                    var yearPicker: Any? = null
                    try {
                        yearPicker = field.get(dp_mes)
                    } catch (e: IllegalAccessException) {
                        e.printStackTrace()
                    }

                    (yearPicker as View).visibility = View.VISIBLE
                }
            }
        }

        builder1.setPositiveButton("Submit") { dialogInterface, i ->
            tv_year.text = "Year: " + month_i[0]
        }
        builder1.setNegativeButton("Cancel") { dialogInterface, i ->

        }
        val alert = builder1.create()
        alert.show()
    }
}