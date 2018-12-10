package com.cdat.adapter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.cdat.R

class HomeMenuAdapter(private val context: FragmentActivity, private val wellnessDrList: ArrayList<String>, clickListener: ClickListener) : RecyclerView.Adapter<HomeMenuAdapter.ViewHolder>() {
    private var mClickListener: ClickListener = clickListener

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_title.text = wellnessDrList[position]
        holder.rl_back.setOnClickListener {
            mClickListener.click(position)
        }
    }


    interface ClickListener {
        fun click(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_home_main_menu, parent, false)

        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return wellnessDrList.size
    }

    override fun getItemViewType(position: Int): Int {
        return wellnessDrList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var rl_back: LinearLayout = itemView.findViewById<LinearLayout>(R.id.rl_back) as LinearLayout
        var tv_title: TextView = itemView.findViewById<TextView>(R.id.tv_title) as TextView

    }


}
