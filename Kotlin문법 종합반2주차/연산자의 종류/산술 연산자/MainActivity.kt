package com.example.practice

fun main(){
    var num1 = 30 //num1에 정수 30을 저장
    var num2 = 10 //num2에 정수 10을 저장

    // 덧셈 연산자(+)사용해서 num1과 num2를 더한후에 plusResult에 대입함
    var plusResult = num1 + num2 //30 + 10과 같은 의미
    println("num1 + num2는 ${plusResult}이야") //num1 + num2를 한 값 즉 30 + 10의 결과 값 출력

    // 뺄셈 연산자(-)사용해서 num1에서 num2를 뺀후에 minusResult에 대입함
    var minusResult = num1 - num2 //30 - 10과 같은 의미
    println("num1 - num2는 ${minusResult}이야") //num1 - num2를 한 값 즉 30 - 10의 결과 값 출력

    // 곱셈 연산자(*)사용해서 num1과 num2를 곱한후에 multipleResult에 대입함
    var multipleResult = num1 * num2 //30 * 10과 같은 의미
    println("num1 * num2는 ${multipleResult}이야") //num1 * num2를 한 값 즉 30 * 10의 결과 값 출력

    // 나눗셈 연산자(/)사용해서 num1에서 num2를 나눈후에 divideResult에 대입함
    var divideResult = num1 / num2 //30 / 10과 같은 의미
    println("num1 / num2는 ${divideResult}이야") //num1 / num2를 한 값 즉 30 / 10의 결과 값 출력

    // num2를 10에서 7로 변경
    num2 = 7

    // 나머지 연산자(%)사용해서 num1에서 num2를 나눈 나머지를 modResult에 대입함
    var modResult = num1 % num2 //30 % 7과 같은 의미
    println("num1 % num2는 정수로 ${modResult}야") //num1 % num2를 한 값 즉 30 % 10의 결과 값 출력
}
