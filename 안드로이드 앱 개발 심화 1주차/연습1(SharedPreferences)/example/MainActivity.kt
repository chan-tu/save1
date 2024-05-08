package com.example.apppractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apppractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            saveData()//저장하기
            Toast.makeText(this, "Data Saved ", Toast.LENGTH_SHORT).show()
        }
        loadData()//불러오기
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        //'pref'라는 파일이름으로 Preferences 생성
        val edit = pref.edit()//수정모드
        // 1번째 인자는 키, 2번째 인자는 실제 담아둘 값
        edit.putString("name", binding.editText.text.toString())
        //edit를 할때 putString라는 값에 name이라는 키값에 내가 만든 editText를 저장
        edit.apply() //저장완료
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        //pref라는 이름으로 Preferences 생성
        binding.editText.setText(pref.getString("name", ""))
        //저장한 키 값을 불러와 setText에 저장
        //단 저장된 키 값을 호출 할 때는 'defValue'를 반드시 지정\
        //저장하지 않고 get를 먼저할 경우(한 번도 설정하지 않는 상황)에 defValue이 들어옴
    }
}
