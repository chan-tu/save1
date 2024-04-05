package com.example.app

fun main() {
    var name = readLine().toString()
    if(name is String) {
        //name에 저장된 값을 보는 것이 아니라 변수 name이 어떤 자료형을 가지고 있는지 확인
        println("name은 String 타입입니다")
    } else {
        println("name은 String 타입이 아닙니다")
    }
}
