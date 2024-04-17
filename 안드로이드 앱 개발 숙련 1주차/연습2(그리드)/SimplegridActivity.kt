package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.app.databinding.ActivitySimplegridBinding

class SimplegridActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimplegridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simplegrid)

        binding= ActivitySimplegridBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items= arrayOf<String?>("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6",  "item7", "item8")

        val adapter=ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        binding.gridview.adapter=adapter

    }
}
