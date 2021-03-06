package com.cdat.adapter.daic

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

class MotilityStrawDIACListAdapter(private val context: FragmentActivity, private val productList: ArrayList<String>, clickListener: ManageCart)
    : RecyclerView.Adapter<MotilityStrawDIACListAdapter.ViewHolder>(), Filterable {


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
        val view = LayoutInflater.from(context).inflate(R.layout.item_motility_straw_diac, parent, false)
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

        var tv_dob: TextView = itemView.findViewById<TextView>(R.id.tv_dob) as TextView
        var tv_animalCat: TextView = itemView.findViewById<TextView>(R.id.tv_animalCat) as TextView
        var tv_animalBreedCat: TextView = itemView.findViewById<TextView>(R.id.tv_animalBreedCat) as TextView
        var tv_animalBreedBldLvl: TextView = itemView.findViewById<TextView>(R.id.tv_animalBreedBldLvl) as TextView
        var tv_bull_no: TextView = itemView.findViewById<TextView>(R.id.tv_bull_no) as TextView
        var tv_batchNo: TextView = itemView.findViewById<TextView>(R.id.tv_batchNo) as TextView
        var tv_StrawUsed: TextView = itemView.findViewById<TextView>(R.id.tv_StrawUsed) as TextView
        var tv_mobilityResult: TextView = itemView.findViewById<TextView>(R.id.tv_mobilityResult) as TextView
        var iv_delete: ImageView = itemView.findViewById<ImageView>(R.id.iv_delete) as ImageView
        var iv_edit: ImageView = itemView.findViewById<ImageView>(R.id.iv_edit) as ImageView

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