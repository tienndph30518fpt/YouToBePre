package com.duytien.youtobepre.apdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.Model.Login_Setting
import com.duytien.youtobepre.R

class Login_setting_Adapter (private val itemList: List<Login_Setting>): RecyclerView.Adapter<Login_setting_Adapter.ItemViewHolder>(){

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title_login: TextView = itemView.findViewById(R.id.title_decs_login)
      //  val btnLogin: Button = itemView.findViewById(R.id.btnLogin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_login_desc, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.title_login.text = currentItem.title
      //  holder.btnLogin.text = currentItem.btnLogin
    }
}