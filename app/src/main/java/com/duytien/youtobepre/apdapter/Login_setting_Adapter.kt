

package com.duytien.youtobepre.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.Model.DataTypeSetting
import com.duytien.youtobepre.Model.Item_setting
import com.duytien.youtobepre.Model.Login_Setting
import com.duytien.youtobepre.R
import com.duytien.youtobepre.apdapter.OnItemClickListener

class Login_setting_Adapter(
    private val itemList: List<Any>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DataTypeSetting.SETTING -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_login_desc, parent, false)
                SettingViewHolder(view)
            }
            DataTypeSetting.SETTING_ITEM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_setting_view, parent, false)
                ItemSettingViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SettingViewHolder -> holder.bind(itemList[position] as Login_Setting)
            is ItemSettingViewHolder -> holder.bind(itemList[position] as Item_setting)
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is Login_Setting -> DataTypeSetting.SETTING
            is Item_setting -> DataTypeSetting.SETTING_ITEM
            else -> throw IllegalArgumentException("Invalid data type")
        }
    }

    inner class SettingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     //   private val author: TextView = itemView.findViewById(R.id.textContent)

        fun bind(loginSetting: Login_Setting) {
        //    author.text = loginSetting.description
            itemView.setOnClickListener {
                listener.onItemClick(loginSetting)
            }
        }
    }

    inner class ItemSettingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageSetting: ImageView = itemView.findViewById(R.id.image_setting)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_setting_title)

        fun bind(itemSetting: Item_setting) {
            imageSetting.setImageResource(itemSetting.image)
            tvTitle.text = itemSetting.title
            itemView.setOnClickListener {
                listener.onItemClick(itemSetting)
            }
        }
    }
}
