package com.example.practice

fun main(){
    //조건 입력
    var eventName = readln()
    var myName = readln()

    if(myName == eventName) { //if안에 변수 myName과 변수 eventName이 같으면 true로 확인
        println("환영합니다 ${myName}님! 이벤트에 당첨됐어요!")
    } else { //myName과 eventName이 다른 fales로 확인
        println("환영합니다 ${myName}님!")
    }
}
