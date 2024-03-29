package com.example.calculater_application


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var login: Button
    private lateinit var iD: EditText
    private lateinit var password: EditText
    private lateinit var join: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login=findViewById(R.id.loginButton)
        join=findViewById(R.id.joinButton)
        iD=findViewById(R.id.textID)
        password=findViewById(R.id.textPassword)

        login.setOnClickListener {
            val useId = iD.text.toString()
            val usePass = password.text.toString()

            if (useId == iD.text.toString() && usePass == password.text.toString()) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else if (useId == iD.text.toString() && usePass == "") {
                Toast.makeText(this, "비밀번호를 입력하시오", Toast.LENGTH_SHORT).show()
            } else if (useId == "" && usePass == password.text.toString()) {
                Toast.makeText(this, "아이디를 입력하시오", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "아이디와 비밀번호을 모두 입력하시오", Toast.LENGTH_SHORT).show()
            }

        }

        join.setOnClickListener {
            Toast.makeText(this, "회원가입", Toast.LENGTH_SHORT).show()
        }
    }

}
