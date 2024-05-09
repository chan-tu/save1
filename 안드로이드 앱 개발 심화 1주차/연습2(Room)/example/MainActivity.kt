package com.example.apppractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apppractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var myDao: MyDAO
    //전역 변수 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        myDao = MyDatabase.getDatabase(this).getMyDao()
        //MyDatabase에서 getDatabase을 가져와 INSTANCE를 받음

        val allStudent = myDao.getAllStudents()
        //allStudent를 선언하여 myDao에서 getAllStudents을 호출하여 <List<Student>> 받음
        //<List<Student>>는 LiveData로 선언됨
        allStudent.observe(this) {
            //allStudent.observe를 하면 student데이터가 변경 될때 마다 observe가 호출
            val str = StringBuilder().apply {
                for ((id, name) in it) {
                    //observe가 호출되면 StringBuilder를 통해 for문이 실행
                    append(id)
                    append("-")
                    append(name)
                    append("\n")
                }
            }.toString()
            binding.studentListText2.text = str
        }
        binding.studentAddButton.setOnClickListener {
            val id = binding.studentIDEditText.text.toString().toInt()
            val name = binding.studentNameEditText.text.toString()
            if (id > 0 && name.isNotBlank()) {
                //비어는지 아닌지 확인
                CoroutineScope(Dispatchers.IO).launch {
                    myDao.insertStudent(Student(id, name))
                    //비어있지 않으면 insertStudent를 호출
                    //insertStudent에는 Student라는 객체를 저장하고 Student 객체에는 id와 name를 저장
                }
            }

            binding.studentIDEditText.text = null
            binding.studentNameEditText.text = null
        }

        binding.queryButton.setOnClickListener {
            val name = binding.studentNameEditText.text.toString()
            //queryButton를 터치 시 studentNameEditText를 받고 name에 저장
            CoroutineScope(Dispatchers.IO).launch {
                val result = myDao.getStudentByName(name)
                //name를 getStudentByName에 저장
                //getStudentByName는 이름을 검색하겠다는 의미
                if (result.isNotEmpty()) {
                    //result가 비어있는지 아닌지 확인
                    val str = StringBuilder().apply {
                        result.forEach { student ->
                            //비어 있지 않으면 result.forEach를 실행
                            append(student.id)
                            append("-")
                            append(student.name)
                        }
                    }
                    withContext(Dispatchers.Main) {
                        binding.studentQueryText.text = str
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        binding.studentQueryText.text = ""
                    }
                }
            }
        }
    }
}
