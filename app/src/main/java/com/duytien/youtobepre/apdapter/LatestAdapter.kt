package com.duytien.youtobepre.apdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duytien.youtobepre.Model.ChannelData
import com.duytien.youtobepre.Model.DataType
import com.duytien.youtobepre.Model.PlayData
import com.duytien.youtobepre.Model.VideoData
import com.duytien.youtobepre.R

class LatestAdapter(private val listData: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DataType.VIDEO -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_item_video, parent, false)
                LatestVideoViewHolder(view)
            }

            DataType.PLAYLIST -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_item_playlist, parent, false)
                LatestPlayListViewHolder(view)
            }

            DataType.CHANNEL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_item_channel, parent, false)
                LatestChannelViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            DataType.VIDEO -> (holder as LatestVideoViewHolder).bind(listData[position] as VideoData)
            DataType.CHANNEL -> (holder as LatestChannelViewHolder).bind(listData[position] as ChannelData)
            DataType.PLAYLIST -> (holder as LatestPlayListViewHolder).bind(listData[position] as PlayData)

        }
    }

    inner class LatestVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val thumbnailImg = itemView.findViewById<ImageView>(R.id.thumbnail_img)
        private val author = itemView.findViewById<TextView>(R.id.tv_length_video)
        private val channelImg = itemView.findViewById<ImageView>(R.id.channel_img)
        private val title = itemView.findViewById<TextView>(R.id.tv_tittle)
        private val description = itemView.findViewById<TextView>(R.id.tv_description)

        fun bind(videoData: VideoData) {
            thumbnailImg.setImageResource(videoData.thumbnails)
            author.text = videoData.author
            channelImg.setImageResource(videoData.channel_img)
            title.text = videoData.title
            description.text = videoData.description
        }
    }

    inner class LatestChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

    inner class LatestPlayListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imagePlayList = itemView.findViewById<ImageView>(R.id.thumbnail_image_playlist)
        private val videoCounPlayList = itemView.findViewById<TextView>(R.id.tv_video_count_playlist)
        private val descriptionPlayList = itemView.findViewById<TextView>(R.id.tv_description_playlist)
        private val titlePlayList = itemView.findViewById<TextView>(R.id.tv_title_playlist)
        fun bind(playData: PlayData) {
            imagePlayList.setImageResource(playData.imageResId)
            videoCounPlayList.text = playData.videoCountPlay
            descriptionPlayList.text = playData.description
            titlePlayList.text = playData.title
        }
    }

}