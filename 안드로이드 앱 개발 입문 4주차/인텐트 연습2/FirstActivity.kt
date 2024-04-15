package com.example.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btn = findViewById<Button>(R.id.bt1)
        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    fun doOnBtnClick(view: View) { //doOnBtnClick는 'Dial_bt'버튼이 눌리거나 'Map_bt'버튼이 눌리거나 같은 함수를 호출
        when (view.getId()) { //view.getId로 'Dial_bt'과'Map_bt'를 구분
            R.id.Dial_bt -> {
                val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))
                startActivity(callIntent)
            }

            R.id.Map_bt -> {
                val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.565350, 127.01445"))
                startActivity(mapIntent)
            }
        }
    }

}
