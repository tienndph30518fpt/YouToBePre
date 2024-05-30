package com.duytien.youtobepre.adapter_item_setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.R
import com.duytien.youtobepre.model_item_seting.Memory

class MemoryItemAdapter (private val itemList: List<Memory>): RecyclerView.Adapter<MemoryItemAdapter.MyViewHor>() {
    class MyViewHor (itemView: View): RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_memory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHor {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memory, parent, false)
        return MyViewHor(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHor, position: Int) {
        val vitri = itemList[position]
        holder.title.text = vitri.title
    }
}