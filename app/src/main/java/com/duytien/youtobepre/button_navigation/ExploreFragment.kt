import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.duytien.youtobepre.R
import com.duytien.youtobepre.fragment_explore.GameFragment
import com.duytien.youtobepre.fragment_explore.LatestFragment
import com.duytien.youtobepre.fragment_explore.MovieFragment
import com.duytien.youtobepre.fragment_explore.MusicFragment
import com.google.android.material.tabs.TabLayout

class ExploreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = PagerAdapter(childFragmentManager)
        pagerAdapter.addFragment(LatestFragment(), "Mới Nhất")
        pagerAdapter.addFragment(MusicFragment(), "Âm nhạc")
        pagerAdapter.addFragment(GameFragment(), "Trò chơi")
        pagerAdapter.addFragment(MovieFragment(), "Phim ảnh")

        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = pagerAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

    }
}
