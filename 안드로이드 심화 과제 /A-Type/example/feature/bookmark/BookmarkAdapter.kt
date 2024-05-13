package com.example.myapp.feature.bookmark

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapp.utils.Utils.getDateFromTimestampWithFormat
import com.example.myapp.databinding.SearchItemBinding
import com.example.myapp.model.SearchltemModel

class BookmarkAdapter(var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var items= mutableListOf<SearchltemModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding=SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(mContext)
            .load(items[position].uri)
            .into((holder as ItemViewHolder).image)

        holder.title.text=items[position].title
        holder.like.visibility=View.GONE
        holder.datatime.text=
            getDateFromTimestampWithFormat(
                items[position].deteTime,
                "yyyy-MM-dd'T'HH:mm:ss.SSS+09:00",
                "yyyy-MM-dd HH:mm:ss"
            )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(binding: SearchItemBinding):RecyclerView.ViewHolder(binding.root){
        var image:ImageView=binding.imageView
        var like:ImageView=binding.likeImage
        var title:TextView=binding.titleText
        var datatime:TextView=binding.TimeText
        var cl_item:ConstraintLayout=binding.clThumbItem
        init {
            like.visibility=View.GONE

            cl_item.setOnClickListener {
                val position=adapterPosition
                if(position!=RecyclerView.NO_POSITION){
                    items.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }
}
