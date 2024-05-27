//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.duytien.youtobepre.Model.Content
//import com.duytien.youtobepre.R
//
//class ContentAdapter(private val contentList: List<Content>) : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
//        return ContentViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
//        holder.bind(contentList[position])
//    }
//
//    override fun getItemCount(): Int {
//        return contentList.size
//    }
//
//    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
////        private val imageViewThumbnail: ImageView = itemView.findViewById(R.id.imageThumbnail)
////        private val textViewTitle: TextView = itemView.findViewById(R.id.tvViewTitle)
//
//        fun bind(content: Content) {
//            // Bind dữ liệu từ content vào các view trong item layout
//            imageViewThumbnail.setImageResource(content.thumbnails)
//            textViewTitle.text = content.title
//        }
//    }
//}
