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
import com.duytien.youtobepre.Model.PlayData
import com.duytien.youtobepre.Model.VideoData
import com.duytien.youtobepre.R


class MusicFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: MultiTypeAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)
        recyclerView = view.findViewById(R.id.recyclerMusic)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listDate = listOf(

//            VideoData(R.drawable.load_mipmap, "00:00:00", R.drawable.load_mipmap,
//                "CHUNG CỰC BÚT KÝ - Tập 34 | Siêu Phẩm Phim Hành Động Thám Hiểm Cực Hot | iQIYI Phim Thuyết Minh",
//                "iQIYI Phim Thuyết Minh"),
            PlayData(
                R.drawable.load_mipmap,
                "phim việt nam",
                "CHUNG CỰC BÚT KÝ - Tập 34 | Siêu Phẩm Phim Hành Động Thám Hiểm Cực Hot | iQIYI Phim Thuyết Minh",
                "100 video"
            ),
//            ChannelData("Nguyễn Duy Tiến", R.drawable.load_mipmap, "123 subscribe", "1003 video" ),
//            ChannelData("Nguyễn Duy Tiến", R.drawable.load_mipmap, "10M subscribe", "12 video" ),
            PlayData(
                R.drawable.load_mipmap,
                "phim Mỹ",
                "Tây du ký - Tập 34 | Siêu Phẩm Phim Hành Động Thám Hiểm Cực Hot | iQIYI Phim Thuyết Minh",
                "100 video"
            ),
            PlayData(
                R.drawable.load_mipmap,
                "phim Mỹ",
                "Tây du ký - Tập 34 | Siêu Phẩm Phim Hành Động Thám Hiểm Cực Hot | iQIYI Phim Thuyết Minh",
                "100 video"
            ),
            PlayData(
                R.drawable.load_mipmap,
                "phim Mỹ",
                "Tây du ký - Tập 34 | Siêu Phẩm Phim Hành Động Thám Hiểm Cực Hot | iQIYI Phim Thuyết Minh",
                "100 video"
            ),

//            VideoData(R.drawable.load_mipmap, "00:00:00", R.drawable.load_mipmap,
//                "CHUNG CỰC BÚT KÝ - Tập 34 | Siêu Phẩm Phim Hành Động Thám Hiểm Cực Hot | iQIYI Phim Thuyết Minh",
//                "iQIYI Phim Thuyết Minh")

        )

        adapter = MultiTypeAdapter(listDate)

        recyclerView.adapter = adapter
    }
}