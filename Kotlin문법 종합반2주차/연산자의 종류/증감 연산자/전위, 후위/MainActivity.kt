package com.example.practice

fun main(){
    var num1 = 10
    var num2 = 20
    var num3 = 30

    // 후위연산자는 println연산을 실행후에 증감해요
    println(num1++) //println으로 10출력 후 1 증가 -> 10 + 1
    println(num1) //printlln으로 11 출력

    // 전위연산자는 println연산 실행전에 증감해요
    println(++num2) //20에 1 증가한 후 println 으로 출력
    println(num2) //println으로 num2에 변경된 값 출력

    num3++ //다른 연산자와 같이 사용하지 단독으로 사용하면 num3에 저장된 값은 31으로 변경
    println(num3) //println으로 num3에 변경된 값 출력

    ++num3 //다른 연산자와 같이 사용하지 단독으로 사용하면 num3에 저장된 값은 32으로 변경
    println(num3) //println으로 num3에 변경된 값 출력
}
