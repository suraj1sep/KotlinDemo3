package com.cdat.adapter.lab

import android.graphics.Color
import android.graphics.Typeface
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cdat.R
import java.text.Normalizer

/**
 * Created by SAM on 17-11-2018.
 */
class AnnualStrawPlanLabListAdapter(private val context: FragmentActivity, private val productList: ArrayList<String>, clickListener: ManageCart)
    : RecyclerView.Adapter<AnnualStrawPlanLabListAdapter.ViewHolder>(), Filterable {


    private var mFilteredList: ArrayList<String>

    init {
        mFilteredList = productList
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                var charString = charSequence.toString()
                if (charString.isEmpty()) {

                    mFilteredList = productList
                } else {
                    val filteredList = java.util.ArrayList<String>()
                    for (androidVersion in productList) {
                        if (androidVersion.toLowerCase().contains(charString)) {
                            filteredList.add(androidVersion)
                        }
                    }
                    mFilteredList = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = mFilteredList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                mFilteredList = filterResults.values as java.util.ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }

    private var mClickListener: ManageCart = clickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_annual_straw_plan_lab, parent, false)
        return ViewHolder(view)
    }

    interface ManageCart {
        fun cart()
    }

    override fun getItemCount(): Int {
        return mFilteredList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        if (BullListFragment.searchText!!.isEmpty())
//            holder.tv_product_name.text = mFilteredList.get(position)
//        else
//            holder.tv_product_name.text = highlightText(BullListFragment.searchText, mFilteredList.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        var tv_product_name: TextView = itemView.findViewById<TextView>(R.id.tv_product_name) as TextView
//        var tv_qty: TextView = itemView.findViewById<TextView>(R.id.tv_qty) as TextView
//        var tv_price: TextView = itemView.findViewById<TextView>(R.id.tv_price) as TextView
//        var btn_add_cart: Button = itemView.findViewById<Button>(R.id.btn_add_cart) as Button
//        var iv_product_image: ImageView = itemView.findViewById<ImageView>(R.id.iv_product_image) as ImageView

    }

    fun highlightText(search: String?, originalText: String): CharSequence {
        val mHighlightStyle = StyleSpan(Typeface.BOLD)
        if (search != null && !search.equals("", ignoreCase = true)) {
            val normalizedText = Normalizer.normalize(originalText, Normalizer.Form.NFD).replace("\\p{InCombiningDiacriticalMarks}+".toRegex(), "").toLowerCase()
            var start = normalizedText.indexOf(search)
            if (start < 0) {
                return originalText
            } else {
                val highlighted = SpannableString(originalText)
                while (start >= 0) {
                    val spanStart = Math.min(start, originalText.length)
                    val spanEnd = Math.min(start + search.length, originalText.length)
                    highlighted.setSpan(mHighlightStyle, spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    highlighted.setSpan(ForegroundColorSpan(Color.parseColor("#2196f3")), spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    start = normalizedText.indexOf(search, spanEnd)
                }
                return highlighted
            }
        }
        return originalText
    }
}