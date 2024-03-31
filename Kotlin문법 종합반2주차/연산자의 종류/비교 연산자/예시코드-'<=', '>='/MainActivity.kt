package com.example.practice

fun main(){
    // 영어 점수 입력
    var englishScore = readln().toInt()
    println("내 영어점수는 ${englishScore}")

    // 영어점수가 60점 이상인지 판단
    var isEnglishMiddleRank = englishScore >= 60 //연산자 '>='를 사용

    // 60점 이상이라면 true (참)
    // 60점 미만이라면 false (거짓)
    println("내 영어점수는 턱걸이로 중위권이 맞나요? ${isEnglishMiddleRank}")
}
