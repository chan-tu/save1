package com.example.practice

fun main(){
    // 1부터 10까지 변화하는 i변수
    for(i in 1..10) { //i는 상수로 만들어지며 상수 1~10까지 출력(until 미사용)
        println("${i}번째: 내 이름은 참새")
    }

    for(i in 1 until 10) { //i는 상수로 만들어지며 상수 1~9까지 출력(until 사용)
        println("${i}번째: 내 이름은 참새")
    }
}
