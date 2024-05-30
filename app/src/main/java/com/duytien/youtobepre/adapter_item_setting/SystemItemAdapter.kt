package com.duytien.youtobepre.adapter_item_setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.R
import com.duytien.youtobepre.model_item_seting.System_Setting
import com.google.android.material.switchmaterial.SwitchMaterial

class SystemItemAdapter (private val itemList: List<System_Setting>):
    RecyclerView.Adapter<SystemItemAdapter.MyViewHor>() {
    class MyViewHor(itemView:  View): RecyclerView.ViewHolder(itemView){
        val description: TextView = itemView.findViewById(R.id.tv_description_system)
        val title: TextView = itemView.findViewById(R.id.tv_titleSystem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHor {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_system, parent, false)
    return MyViewHor(view)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHor, position: Int) {
        val item = itemList[position]
        holder.title.text = item.title
        holder.description.text = item.description
    }
}