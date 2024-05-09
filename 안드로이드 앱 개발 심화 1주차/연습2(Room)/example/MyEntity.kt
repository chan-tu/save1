package com.example.apppractice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
//tableName(테이블 이름)에는 'student_table'이 저장
data class Student(
    @PrimaryKey @ColumnInfo(name = "student_id")
    val id: Int,
    val name: String
    //id와 name는 'student_id'라는 이름으로 데이터 베이스에 저장
)
