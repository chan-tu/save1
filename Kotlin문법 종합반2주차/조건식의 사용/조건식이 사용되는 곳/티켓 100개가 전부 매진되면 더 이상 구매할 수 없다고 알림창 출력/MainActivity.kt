package com.example.practice

fun main(){
    //조건 입력
    var ticketCount = readln().toInt()

    //사람들이 티켓 구매를 눌렀을 때 실행
    if(ticketCount > 0) { //ticketCount가 0보다 많으면 true
        println("티켓을 구매했어요")
    } else { //ticketCount가 0이면 false
        println("티켓이 모두 매진되었습니다")
    }
}
