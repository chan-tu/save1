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
            }
            val intent=Intent(this,MainhomeActivity::class.java)
            intent.putExtra("ID",etId.text.toString())
            startActivity(intent)
        }

        btJi.setOnClickListener {
            val intent=Intent(this,MembershipActivity::class.java)
            startActivity(intent)

            /*val intent=Intent(this,MainhomeActivity::class.java)
            activityResultLauncher.launch(intent)*/
        }
    }
}
