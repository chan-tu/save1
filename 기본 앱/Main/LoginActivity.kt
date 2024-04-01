package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

        val etId=findViewById<EditText>(R.id.edit_Id)
        val etPw=findViewById<EditText>(R.id.edit_Pass)
        val btLog=findViewById<Button>(R.id.bt_Log)
        val btJi=findViewById<Button>(R.id.join)

        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode== RESULT_OK){
                val useId=it.data?.getStringExtra("ID")
                val usePass=it.data?.getStringExtra("PASS")
                etId.setText(useId)
                etPw.setText(usePass)
            }
        }
        btLog.setOnClickListener {
            if (etId.text.trim().isEmpty()||etPw.text.trim().isEmpty()){
                Toast.makeText(this,getString(R.string.toast_message),Toast.LENGTH_SHORT).show()
                return@setOnClickListener
                //trim(): 공간빼기
                //isEmpty():비어있는지 확인
                //getString으로 텍스트 문구 호출
                //여기서 함수를 종료해야하기 때문에 리턴 값 호출
            }
            
            val intent=Intent(this,MainhomeActivity::class.java)
            intent.putExtra("ID",etId.text.toString())
            startActivity(intent)
            //putExtra("키값", 호출 내용)
            //Loging 눌렀을 떄 HomeActivity 실행
            
        }//호출하면 끝

        btJi.setOnClickListener {
            val intent=Intent(this,MembershipActivity::class.java)
            startActivity(intent)

            val intent=Intent(this,MainhomeActivity::class.java)
            activityResultLauncher.launch(intent)
            
            //MembershipActivity를 답장을 줘라고 하면서 호출
            //답장이 오면서 activityResultLauncher 실행
        }//답장을 다시 보내라는 요청을 했을 떄 activityResultLauncher가 실행
    }
}
