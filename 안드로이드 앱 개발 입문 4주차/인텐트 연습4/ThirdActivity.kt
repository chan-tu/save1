package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val strData = intent.getStringExtra("dataFromFirstActivity")
        val editThird = findViewById<EditText>(R.id.ed_Th)
        editThird.setText(strData)

        val btCl = findViewById<Button>(R.id.bt3)
        btCl.setOnClickListener {
            finish()
        }
    }
}
