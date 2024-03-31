package com.example.practice

fun main(){
    // 수학점수 입력
    var mathScore = readln().toInt()
    println("내 수학점수 ${mathScore}")

    // 수학점수가 90점 초과인지 판단
    var isMathHighRank = mathScore > 90 //연산자 '>'를 사용

    // 90점 초과라면 true (참)
    // 90점 이하라면 false (거짓)
    println("내 수학점수는 고등급이 맞나요? ${isMathHighRank}")
}
