package com.example.app

fun main() {
    while(true) {
        try {
            var num1 = readLine()!!.toInt()
            println("내가 입력한 숫자는 ${num1}입니다")
            break
        } catch(e:java.lang.NumberFormatException) {
            println("숫자를 입력하세요")
        } finally {
            println("키보드와의 연결은 정상적입니다")
        }//try-catch랑 상관없이 항상 실행되는 구문
    }
}
