package com.example.app

fun main() {
    var add = {num1: Int, num2: Int, num3: Int -> (num1+num2+num3) / 3}
    //add라는 함수
    //'='대신 '->'이용하여 람다식을 정의
    //따로 영역을 두지 않고 변수 처럼 간단한 람다식 생성
    println("평균값은 ${add(10,20,30)}입니다")
    
}
