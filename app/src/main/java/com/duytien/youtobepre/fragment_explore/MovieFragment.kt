package com.duytien.youtobepre.fragment_explore

import MultiTypeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.Model.ChannelData
import com.duytien.youtobepre.R


class MovieFragment : Fragment(R.layout.fragment_movie) {
private lateinit var recyclerView: RecyclerView
private lateinit var adapter: MultiTypeAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        recyclerView = view.findViewById(R.id.recyclerMovie)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listData = listOf(
            ChannelData("Nguyễn Duy Tiến", R.drawable.load_mipmap, "123 subscribe", "1003 video"),
            ChannelData("Nguyễn Duy Tiến", R.drawable.load_mipmap, "10M subscribe", "1245 video"),
            ChannelData("Nguyễn Duy Tiến", R.drawable.load_mipmap, "10M subscribe", "445 video"),
            ChannelData("Nguyễn Duy Tiến", R.drawable.load_mipmap, "10M subscribe", "12 video"),
        )
        adapter = MultiTypeAdapter(listData)

        recyclerView.adapter = adapter
    }
}