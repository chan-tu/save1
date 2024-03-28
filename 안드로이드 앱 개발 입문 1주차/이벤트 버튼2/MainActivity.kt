package com.example.practice2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButton1Clicked(v:View){
        val myIntent1 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.madeedam.com/"))
        startActivity(myIntent1)

    }

    fun onButton2Clicked(v:View){
        val myIntent2 = Intent(Intent.ACTION_VIEW, Uri.parse("Tel:010-1234-5678"))
        startActivity(myIntent2)

    }
}
