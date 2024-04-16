package com.example.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {

    val tag = "FirstActivity_Lifrcycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Log.i(tag, "onCreat")

        val btn = findViewById<Button>(R.id.bt1)
        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val btnCall = findViewById<Button>(R.id.bt_At)
        btnCall.setOnClickListener {
            val editText = findViewById<EditText>(R.id.ed_Tx)
            val stringData = editText.text.toString()
            val inTet = Intent(this, ThirdActivity::class.java)
            inTet.putExtra("dataFromFirstActivity", stringData)
            startActivity(inTet)
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

    override fun onStart() {
        super.onStart()
        Log.i(tag, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tag, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "onestroy()")
    }

}
