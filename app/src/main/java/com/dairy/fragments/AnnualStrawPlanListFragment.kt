package com.dairy.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.dairy.R
import com.dairy.adapter.AnnualStrawPlanLabListAdapter


/**
 * Created by SAM on 17-11-2018.
 */
class AnnualStrawPlanListFragment : Fragment() {

    companion object {
        private lateinit var recyclerView: RecyclerView
        private lateinit var et_search: EditText
        private val categoryList: ArrayList<String> = ArrayList()
        lateinit var manageCart: AnnualStrawPlanLabListAdapter.ManageCart
        public var searchText: String = ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Annual Straw Plan"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_annual_straw_plan_list, container, false)

        et_search = view.findViewById(R.id.et_search) as EditText
        recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView


        manageCart = object : AnnualStrawPlanLabListAdapter.ManageCart {
            override fun cart() {
            }
        }
        init()
        //item_annual_straw_plan_lab

        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        var adapter1 = AnnualStrawPlanLabListAdapter(this!!.activity!!, categoryList, manageCart)
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
        categoryList.add("Dhahi")
        categoryList.add("Pneer")
        categoryList.add("Milk")
        categoryList.add("Dhahi")
        categoryList.add("Pneer")
    }
}