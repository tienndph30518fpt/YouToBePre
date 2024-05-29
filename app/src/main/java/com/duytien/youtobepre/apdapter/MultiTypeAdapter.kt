import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.Model.DataType
import com.duytien.youtobepre.Model.PlayData
import com.duytien.youtobepre.Model.ChannelData
import com.duytien.youtobepre.Model.VideoData
import com.duytien.youtobepre.R

class MultiTypeAdapter(private val dataList: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DataType.VIDEO -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_video, parent, false)
                VideoViewHolder(view)
            }
            DataType.PLAYLIST -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_playlist, parent, false)
                ImageViewHolder(view)
            }
            DataType.CHANNEL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_channel, parent, false)
                TextViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            DataType.VIDEO -> (holder as VideoViewHolder).bind(dataList[position] as VideoData)
            DataType.PLAYLIST -> (holder as ImageViewHolder).bind(dataList[position] as PlayData)
            DataType.CHANNEL -> (holder as TextViewHolder).bind(dataList[position] as ChannelData)
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is VideoData -> DataType.VIDEO
            is PlayData -> DataType.PLAYLIST
            is ChannelData -> DataType.CHANNEL
            else -> throw IllegalArgumentException("Invalid data type")
        }
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val thumbnail = itemView.findViewById<ImageView>(R.id.thumbnail_img)
        private val author = itemView.findViewById<TextView>(R.id.tv_length_video)
        private val channel_img = itemView.findViewById<ImageView>(R.id.channel_img)
        private val title = itemView.findViewById<TextView>(R.id.tv_tittle)
        private val description = itemView.findViewById<TextView>(R.id.tv_description)
        fun bind(videoData: VideoData) {
            thumbnail.setImageResource(videoData.thumbnails)
            author.text = videoData.author
            channel_img.setImageResource(videoData.channel_img)
            title.text = videoData.title
            description.text = videoData.description
        }
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.thumbnail_image_playlist)
        private val videoCountPlay = itemView.findViewById<TextView>(R.id.tv_video_count_playlist)
        private val description = itemView.findViewById<TextView>(R.id.tv_description_playlist)
        private val title_playlist = itemView.findViewById<TextView>(R.id.tv_title_playlist)

        fun bind(playData: PlayData) {
            image.setImageResource(playData.imageResId)
            description.text = playData.description
            videoCountPlay.text = playData.videoCountPlay
            title_playlist.text = playData.title
        }
    }

    inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageChannel = itemView.findViewById<ImageView>(R.id.image_channel)
        private val author = itemView.findViewById<TextView>(R.id.textContent)
        private val subscribe = itemView.findViewById<TextView>(R.id.tv_subscription)
        private val count_video = itemView.findViewById<TextView>(R.id.tv_video_count)
        fun bind(channelData: ChannelData) {
            author.text = channelData.author
            imageChannel.setImageResource(channelData.imageChannel)
            subscribe.text = channelData.subscribe
            count_video.text = channelData.count_video
            // còn thiếu đăng ký người dùng
        }
    }
}
