package com.example.practice

fun main(){
    val num1 = 1
    println("내 첫변수 num1 변수에는 ${num1}이 들어있어")

// Val cannot be reassigned 에러 발생!!
// num1은 var이 아니라 val이기때문에 들어있는 값을 변경하지 못함
    num1 = 5

    println("변경한 변수 num1 변수에는 ${num1}이 들어있어")
}
