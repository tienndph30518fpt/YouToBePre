package com.duytien.youtobepre.apdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.Model.DataTypeSetting
import com.duytien.youtobepre.Model.Item_setting
import com.duytien.youtobepre.Model.Login_Setting
import com.duytien.youtobepre.R
import com.duytien.youtobepre.databinding.RecyclerItemLoginDescBinding
import com.duytien.youtobepre.databinding.RecyclerItemSettingViewBinding

class Login_setting_Adapter(private val itemList: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DataTypeSetting.SETTING->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_login_desc, parent, false)
                SettingViewHover(view)

            }
            DataTypeSetting.SETTING_ITEM->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_setting_view, parent, false)
                ItemSettingViewHolder(view)
            }
            else -> throw IllegalArgumentException("loi setting")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder){
           is SettingViewHover -> holder.bind(itemList[position] as Login_Setting)
           is ItemSettingViewHolder -> holder.bind(itemList[position] as Item_setting)
       }

    }

    override fun getItemCount(): Int {
      return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]){
            is Item_setting -> DataTypeSetting.SETTING_ITEM
            is Login_Setting -> DataTypeSetting.SETTING
            else -> throw IllegalArgumentException("data type")
        }

    }

    class SettingViewHover(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageChannel = itemView.findViewById<ImageView>(R.id.image_channel)
        private val author = itemView.findViewById<TextView>(R.id.textContent)
        fun bind(loginSetting: Login_Setting) {

        }
    }

    class ItemSettingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageSetting = itemView.findViewById<ImageView>(R.id.image_setting)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_setting_title)
        fun bind(loginSetting: Item_setting) {
            imageSetting.setImageResource(loginSetting.image)
            tvTitle.text = loginSetting.title
        }
    }
}