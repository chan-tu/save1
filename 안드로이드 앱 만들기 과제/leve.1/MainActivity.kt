package com.example.practice3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var login: Button
    lateinit var Text_ID: EditText
    lateinit var Text_Password: EditText
    lateinit var join: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login.setOnClickListener {
            var use_id = Text_ID.text.toString()
            var use_pass = Text_Password.text.toString()

            if (use_id == Text_ID.text.toString() || use_pass == Text_Password.text.toString()) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else if (use_id == Text_ID.text.toString() || use_pass == "") {
                Toast.makeText(this, "비밀번호를 입력하시오", Toast.LENGTH_SHORT).show()
            } else if (use_id == "" || use_pass == Text_Password.text.toString()) {
                Toast.makeText(this, "아이디를 입력하시오", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "아이디와 비밀번호를 모두 입력하시오.", Toast.LENGTH_SHORT).show()
            }

        }

        join.setOnClickListener {
            Toast.makeText(this, "회원가입", Toast.LENGTH_SHORT).show()
        }
    }

}
