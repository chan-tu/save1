package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityImagegridBinding

class ImagegridActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImagegridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagegrid)

        binding= ActivityImagegridBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageGrid.adapter=Imageadapter()
        
        binding.imageGrid.setOnItemClickListener { parent, view, position, id ->
            //콜백 값으로 'parent, view, position, id'가 넘김
            Toast.makeText(this@ImagegridActivity,""+(position+1)+"번째 선택", Toast.LENGTH_SHORT).show()
            //클릭시 메시지 출력
        }

    }
}
