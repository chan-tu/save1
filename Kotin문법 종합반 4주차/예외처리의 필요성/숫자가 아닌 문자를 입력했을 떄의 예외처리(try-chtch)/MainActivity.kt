package com.example.app

fun main() {
    while(true) {
    //while(true)으로 하면 무한 루프로 반복문 계속 실행
        try {
            var num1 = readLine()!!.toInt()
            println("내가 입력한 숫자는 ${num1}입니다")
            break //숫자를 입력하면 break 실행
        } catch(e:java.lang.NumberFormatException) {
            //예외 발생 시점
            println("숫자를 입력하세요")
            //숫자가 아닌 문자를 입력하면 계속 실행
        }
    }
}
