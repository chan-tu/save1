package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.app.databinding.ActivitySimplelistBinding

class SimplelistActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimplelistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simplelist)

        binding = ActivitySimplelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //데이터 원본 준비
        val item = arrayOf<String?>("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8")
        //아이템 데이터를 String로 정렬하여 아이템1~8까지 세로로 출력되도록 설정

        //어댑터 준비 (배열 객체 이용, simple_list_item_1 리소스 사용
        val adap = ArrayAdapter(this, android.R.layout.simple_list_item_1 ,item)
        //adap를 생성하여 ArrayAdapter를 저장
        //ArrayAdapter에 android.R.layout.simple_list_item_1과 'item'를 저장
        //simple_list_item_1는 안드로이드에서 제공하는 레이아웃

        binding.listView.adapter = adap

    }
}
