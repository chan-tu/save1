package com.example.practice

fun main(){
    val num1 = 1 //상수 'val'에 num1를 선언아여 1 저장
    println("내 첫변수 num1 변수에는 ${num1}이 들어있어")//num1에 저장된 값 출력

// Val cannot be reassigned 에러 발생!!
// num1은 var이 아니라 val이기때문에 들어있는 값을 변경하지 못함
    num1 = 5//num1는 이미 상수로 선언하였기 때문에 다른 값으로 변경 불가

    println("변경한 변수 num1 변수에는 ${num1}이 들어있어")
}
