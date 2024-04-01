package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MembershipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membership)

        val nameEt=findViewById<EditText>(R.id.name_Et)
        val idEt=findViewById<EditText>(R.id.id_Et)
        val pwEt=findViewById<EditText>(R.id.pass_Et)
        val joinBt=findViewById<Button>(R.id.btn_join)

        joinBt.setOnClickListener {
            if(nameEt.text.toString().trim().isEmpty()||idEt.text.toString().trim().isEmpty()||pwEt.text.toString().trim().isEmpty()){
                Toast.makeText(this,getString(R.string.No_Information),Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }//예외처리, 이름, 아이디, 비밀번호 둘중하나만 비어 있으면 메시지 출력

            val intent=Intent(this,LoginActivity::class.java).apply {
                putExtra("ID",idEt.text.toString())
                putExtra("PW",pwEt.text.toString())
            }

            setResult(RESULT_OK,intent)
            //RESULT_OK:-1로 정의
            //setResult를하면 LoginActivity에서 답장 받음

            if(!isFinishing)finish()
            //isFinishing: 앱또는 화면이 종료 중인지 확인
        }
    }
}
