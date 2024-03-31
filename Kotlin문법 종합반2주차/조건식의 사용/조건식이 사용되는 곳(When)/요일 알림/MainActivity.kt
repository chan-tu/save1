package com.example.practice

fun main(){
    val day = readln().toInt()
    val dayString = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        5 -> "금요일"
        6 -> "토요일"
        7 -> "일요일"
        else -> "잘못된 요일"
    }
    println("오늘은 $dayString 입니다.")
}
