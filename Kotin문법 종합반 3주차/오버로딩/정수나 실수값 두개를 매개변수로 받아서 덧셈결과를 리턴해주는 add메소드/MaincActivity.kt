package com.example.app

fun main() {
    var calc = Calculator()

    var intResult = calc.add(readln().toInt(), readln().toInt())//1, 2
    var intResul = calc.add(readln().toInt(), readln().toInt(), readln().toInt())//1, 2
    var doubleResult = calc.add(readln().toDouble(), readln().toDouble())//1.2, 2.2

    println("정수 덧셈결과: ${intResult}")
    println("실수 덧셈결과: ${doubleResult}")
    println("정수 덧셈결과: ${intResul}")

}

class Calculator {

    fun add(num1: Int, num2: Int): Int {
        return num1+num2
    }//정수 2개를 받아 덧셈 결과 리턴하는 메소드

    fun add(num1: Double, num2: Double): Double {
        return num1+num2
    }//실수 2개를 받아 덧셈 결과 리턴하는 메소드

    fun add(num1: Int, num2: Int, num3: Int):Int{
        return num1+num2+num3
    }
}//add를 같이 사용할 수 이유는 반환형 상관없이 파라미터 즉 매개변수 타입이 Int 또는 Double이냐에 따라 다르기 때문에 오버로딩
