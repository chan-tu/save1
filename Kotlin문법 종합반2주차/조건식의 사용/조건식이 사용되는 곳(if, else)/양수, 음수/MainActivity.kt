package com.example.practice

fun main(){
    val number = readln().toInt()

    // if 문 예시
    if (number > 0) {
        println("$number 는 양수입니다.")
    } else if (number < 0) {
        println("$number 는 음수입니다.")
    } else {
        println("$number 는 0 입니다.")
    }
}
