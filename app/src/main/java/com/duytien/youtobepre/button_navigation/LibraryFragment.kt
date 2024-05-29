package com.duytien.youtobepre.button_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.duytien.youtobepre.Model.Item_setting
import com.duytien.youtobepre.Model.Login_Setting
import com.duytien.youtobepre.R
import com.duytien.youtobepre.apdapter.Login_setting_Adapter
import com.duytien.youtobepre.databinding.FragmentLibraryBinding


class LibraryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Login_setting_Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_library, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewLogin)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }
//
//
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = listOf(
            Login_Setting("PHim"),
            Item_setting("Cài đặt", R.drawable.home),
            Item_setting("Chia sẻ ứng dụng", R.drawable.home),
            Item_setting("Kiểm tra bản cập nhật", R.drawable.explore),
            Item_setting("Chính sách bảo mật", R.drawable.account),
        )

    adapter = Login_setting_Adapter(itemList)
    recyclerView.adapter = adapter
    }

}