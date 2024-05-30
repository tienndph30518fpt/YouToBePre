package com.duytien.youtobepre.adapter_item_setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.R
import com.duytien.youtobepre.model_item_seting.Player_setting
import com.google.android.material.switchmaterial.SwitchMaterial

class PlayerItemAdapter (private val itemList:List<Player_setting>):
    RecyclerView.Adapter<PlayerItemAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val titleItem: TextView = itemView.findViewById(R.id.tv_play_item)
        val switchItem: SwitchCompat = itemView.findViewById(R.id.item_switch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return itemList.size
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.titleItem.text = item.title
        holder.switchItem.isChecked = item.switch
    }
}