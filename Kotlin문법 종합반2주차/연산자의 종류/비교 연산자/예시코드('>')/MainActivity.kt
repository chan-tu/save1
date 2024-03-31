package com.example.practice

fun main(){
    // 수학은 94점
    var mathScore = 94

    // 수학점수가 90점 초과인지 판단
    var isMathHighRank = mathScore > 90

    // 90점 초과라면 true (참)
    // 90점 이하라면 false (거짓)
    println("내 수학점수는 고등급이 맞나요? ${isMathHighRank}")
}
