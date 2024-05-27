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
        private val thumbnail = itemView.findViewById<ImageView>(R.id.videoThumbnail)
        private val author = itemView.findViewById<TextView>(R.id.videoAuthor)

        fun bind(videoData: VideoData) {
            thumbnail.setImageResource(videoData.thumbnails)
            author.text = videoData.author
        }
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.imageRes)
        private val description = itemView.findViewById<TextView>(R.id.imageDescription)

        fun bind(playData: PlayData) {
            image.setImageResource(playData.imageResId)
            description.text = playData.description
        }
    }

    inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val content = itemView.findViewById<TextView>(R.id.textContent)

        fun bind(channelData: ChannelData) {
            content.text = channelData.content
        }
    }
}
