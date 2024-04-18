package com.example.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemRecyclerviewBinding

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {
    //RecyclerView를 Adapter로 상속
    //mItems는 MyItem 타입이며 MyItem는 데이터 클래스
    //mItems에 7개의 샘플데이터가 저장

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
        //binding를 Holder에 저장하여 리턴
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        //holder과 position에 샘플데이터가 하나씩 저장
        holder.iconImageView.setImageResource(mItems[position].icon)
        holder.nam.text = mItems[position].name
        holder.ag.text = mItems[position].name
        //onBindViewHolder로 8개의 샘플데이터를 하나씩 실행
        //샘플데이터 개수 만큼 실행(화면에 보이는데까지 실행 만약 화면이 안보이는 곳까지 실행이되면 스크롤로 보여질때까지 불림)

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }
    //getItemId과 getItemCount를 꼭 오버라이딩

    inner class Holder(val binding: ItemRecyclerviewBinding) :
    //Holder는 inner class로 생성
    //ItemRecyclerviewBinding는 item_recyclerview.xml
        RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val nam = binding.textItem1
        val ag = binding.textItem2
        //아이콘, 이름, 나이는 holder로 만들고 계속 재활용

    }
}
