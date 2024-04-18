package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivityRecyclerviewBinding
import com.example.app.databinding.ItemRecyclerviewBinding

class RecyclerviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        binding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //데이터 원본
        val dataList = mutableListOf<MyItem>()
        //데이터 클래스로 받음
        dataList.add(MyItem(R.drawable.sad, "Bella", "1"))
        dataList.add(MyItem(R.drawable.happy, "Chary", "2"))
        dataList.add(MyItem(R.drawable.lave_1, "Daisy", "3"))
        dataList.add(MyItem(R.drawable.lave_2, "Duke", "4"))
        dataList.add(MyItem(R.drawable.lave_3, "Max", "5"))
        dataList.add(MyItem(R.drawable.lave_4, "Luna", "6"))
        dataList.add(MyItem(R.drawable.lave_5, "Happy", "7"))
        //샘플 데이터, 리스트 형태로 화면에 출력

        binding.recyclerView.adapter = MyAdapter(dataList)
        //MyAdapter안에 화면에 출력할 데이터 리스트를 저장

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //layoutManager는 레이아웃를 어떻게 구성할 것인의 의미로 LinearLayoutManager를 그대로 사용

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].name
                Toast.makeText(this@RecyclerviewActivity, "$name 선택", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
