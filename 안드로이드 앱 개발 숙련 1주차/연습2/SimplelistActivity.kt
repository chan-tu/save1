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

        binding= ActivitySimplelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item= arrayOf<String?>("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6",  "item7", "item8")

        val adap=ArrayAdapter(this,android.R.layout.simple_gallery_item,item)

        binding.listView.adapter=adap

    }
}
