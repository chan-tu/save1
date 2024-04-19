package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList= mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.ico_electric_fan,"선풍기","서울 강남구/6일전", "4,000"))
        dataList.add(MyItem(R.drawable.image_sample,"키보드","용인시 수지구/5일전", "10,000"))
        dataList.add(MyItem(R.drawable.bottle,"물병", "서울 송파구/1일전", "2,000"))
        dataList.add(MyItem(R.drawable.knife,"식칼", "용인시 죽전동/13일전", "20,000"))
        dataList.add(MyItem(R.drawable.notebook,"노트북", "서울 영등포구/10일전", "100,000"))
        dataList.add(MyItem(R.drawable.bowl_of_rice,"밥통", "용인시 처인구/3일전", "40,000"))
        dataList.add(MyItem(R.drawable.frame,"액자", "서울 용산구/8일전", "5,000"))
        dataList.add(MyItem(R.drawable.mouse,"마우스", "용인시 기흥구/24일전", "8,000"))
        dataList.add(MyItem(R.drawable.calendar,"달력", "서울 종로구/20일전", "9,000"))
        dataList.add(MyItem(R.drawable.hat,"모자", "용인 보정동/17일전", "7,000"))

        binding.mainRecyclerView.adapter =MyAdapter(dataList)

        val adapter=MyAdapter(dataList)
        binding.mainRecyclerView.adapter=adapter
        binding.mainRecyclerView.layoutManager=LinearLayoutManager(this)

        adapter.itemClick=object :MyAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val name:String=dataList[position].name
                Toast.makeText(this@MainActivity,"$name 선택", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
