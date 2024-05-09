package com.example.apppractice

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)
    //insertStudent는 학생을 추가하겠다는 의미

    @Query("SELECT * FROM student_table")
    fun getAllStudents():LiveData<List<Student>>
    //student_table에 있는 student List를 LiveData로 선언하여 받음
    //변동이 있을 때마다 ListStudent가 리턴 됨

    @Query("SELECT * FROM STUDENT_TABLE WHERE name = :sname")
    suspend fun getStudentByName(sname:String):List<Student>
    //getStudentByName는 이름 검색을 의미
    //getStudentByName를 List<Student>로 지정한 이유는 이름이 여려 명일 수도 있고 같은 이름의 데이터가 있을 수 있기 때문

    @Delete
    suspend fun deletStudent(student: Student);
    //deletStudent는 지우는 것을 의미
}
