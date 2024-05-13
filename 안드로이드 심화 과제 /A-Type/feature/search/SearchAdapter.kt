package com.example.myapp.feature.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapp.MainActivity
import com.example.myapp.utils.Utils.getDateFromTimestampWithFormat
import com.example.myapp.databinding.SearchItemBinding
import com.example.myapp.model.SearchltemModel

class SearchAdapter(private val mContext: Context):RecyclerView.Adapter<SearchAdapter.ItemViewHolder>() {

    var items=ArrayList<SearchltemModel>()

    fun clearItem(){
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding=SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currenctItem =items[position]
        Glide.with(mContext)
            .load(currenctItem.uri)
            .into(holder.thumImga)

        holder.likeIv.visibility=if(currenctItem.isLike)View.VISIBLE else View.INVISIBLE
        holder.titieTv.text=currenctItem.title
        holder.dateTimeTv.text=getDateFromTimestampWithFormat(
            currenctItem.deteTime,
            "yyyy-MM-dd'T'HH:mm:ss.SSS+09:00",
            "yyyy-MM-dd HH:mm:ss"
        )
    }

    override fun getItemCount()=items.size

    inner class ItemViewHolder(binding: SearchItemBinding):RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        var thumImga:ImageView=binding.imageView
        var likeIv:ImageView=binding.likeImage
        var titieTv:TextView=binding.titleText
        var dateTimeTv:TextView=binding.TimeText
        var thumbItemCl:ConstraintLayout=binding.clThumbItem

        init {
            likeIv.visibility=View.GONE
            thumImga.setOnClickListener(this)
            thumbItemCl.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position=adapterPosition.takeIf { it!=RecyclerView.NO_POSITION }?:return
            val item=items[position]
            item.isLike=!item.isLike

            if (item.isLike){
                (mContext as MainActivity).addLikedItem(item)
            }else{
                (mContext as MainActivity).removeLikedItem(item)
            }

            notifyItemRemoved(position)
        }
    }
}
