package com.example.app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainhomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val useId=findViewById<TextView>(R.id.idName)

        if(intent.hasExtra("ID")){
            useId.text="아이디 : "+intent.getStringExtra("ID")
        }

        val btCl=findViewById<ConstraintLayout>(R.id.btclose)
        btCl.setOnClickListener {
            finish()
        }

        val imLg=findViewById<ImageView>(R.id.logoImage)

        val id=when((1 until 6).random()){
            1 ->R.drawable.ca1
            2 ->R.drawable.ca2
            3 ->R.drawable.ca3
            4 ->R.drawable.ca4
            5 ->R.drawable.ca5
            else ->R.drawable.ca1
        }

        imLg.setImageDrawable(ResourcesCompat.getDrawable(resources,id,null))
    }
}
