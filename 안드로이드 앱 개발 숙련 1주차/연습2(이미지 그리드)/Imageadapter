package com.example.app

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class Imageadapter :BaseAdapter() {
    override fun getCount(): Int {
        return mThumbIds.size
    }

    override fun getItem(position: Int): Any {
        return mThumbIds[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }//자동 생성

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val imageView: ImageView
        if (convertView==null){
            imageView=ImageView(parent!!.context)
            imageView.layoutParams=AbsListView.LayoutParams(200, 200)
            //그리드뷰에서 뷰을 요청하여 어떤 형식의 뷰를 보낼 것이냐고 했을 때 이미지뷰 하나 만들어 이미지 뷰 레이아웃를 '200, 200'으로 만듬
            imageView.scaleType=ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)

        } else{
            imageView=convertView as ImageView
        }

        imageView.setImageResource(mThumbIds.get(position))
        return imageView
    }

    private val mThumbIds = arrayOf<Int>(
        R.drawable.sad, R.drawable.happy,
        R.drawable.lave_1, R.drawable.lave_2,
        R.drawable.lave_3, R.drawable.lave_4,
        R.drawable.lave_5, R.drawable.lave_1,

    )
}
