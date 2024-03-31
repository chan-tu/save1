package com.example.practice

fun main(){
    //조건 입력
    var koreanScore =  readln().toInt()
    var englishScore = readln().toInt()
    var mathScore = readln().toInt()
    //koreanScore, englishScore, mathScore 등 3개에 저장된 값을 더하여 3으로 나누고 average에 저장
    var average = (koreanScore + englishScore + mathScore) / 3

    if(average >= 90) { //average가 90이상일 경우 실행
        println("당신의 등급은 A입니다")
    } else if(average >= 80) { //average가 80~89일 경우 실행
        println("당신의 등급은 B입니다")
    } else if(average >= 70) { //average가 70~79일 경우 실행
        println("당신의 등급은 C입니다")
    } else { //average가 70미만일 경우 실행
        println("당신의 등급은 F입니다")
    }
}
