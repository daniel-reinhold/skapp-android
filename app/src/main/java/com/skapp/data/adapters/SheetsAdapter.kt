package com.skapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skapp.R
import com.skapp.R.layout.sheet
import com.skapp.data.retrofit.models.Sheet

class SheetsAdapter(
    var items: MutableList<Sheet>
) : RecyclerView.Adapter<SheetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(sheet, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSheet = items[position]

        holder.title.text = currentSheet.title
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvSheetTitle)
    }

}