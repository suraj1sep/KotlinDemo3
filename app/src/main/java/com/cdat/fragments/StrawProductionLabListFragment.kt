package com.cdat.fragments

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.cdat.R
import android.support.v7.app.AppCompatActivity
import com.cdat.adapter.StrawProductionListAdapter
import com.cdat.helper.Config


/**
 * Created by SAM on 17-11-2018.
 */
class StrawProductionLabListFragment : Fragment() {

    companion object {
        private lateinit var recyclerView: RecyclerView
        private lateinit var et_search: EditText
        private lateinit var fab_add: FloatingActionButton
        private val categoryList: ArrayList<String> = ArrayList()
        lateinit var manageCart: StrawProductionListAdapter.ManageCart
        public var searchText: String = ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Daily Production List"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_bull_list, container, false)

        et_search = view.findViewById(R.id.et_search) as EditText
        recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        fab_add = view.findViewById(R.id.fab_add) as FloatingActionButton

        fab_add.setOnClickListener {
            val registerFragment = StrawProductionAddFragment()
            Config.slideFragment(registerFragment, "", fragmentManager!!, R.id.content_frame, "ankole")
        }

        manageCart = object : StrawProductionListAdapter.ManageCart {
            override fun cart() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        init()

        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        var adapter1 = StrawProductionListAdapter(this!!.activity!!, categoryList, manageCart)
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