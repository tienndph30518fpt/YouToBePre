import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.Model.PlayData
import com.duytien.youtobepre.Model.ChannelData
import com.duytien.youtobepre.Model.VideoData
import com.duytien.youtobepre.R

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MultiTypeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewHome)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contentList = listOf(
            VideoData(R.drawable.thum, "Phim hành động"),
            PlayData(R.drawable.logo_youtobe, "Phim ngắn"),
            ChannelData("Nguyễn Duy Tiến"),
            VideoData(R.drawable.thum, "Author 2"),
            PlayData(R.drawable.logo_youtobe, "Chấn động địa cầu"),
            ChannelData("Duy Tiến")
        )
        adapter = MultiTypeAdapter(contentList)
        recyclerView.adapter = adapter
    }
}
