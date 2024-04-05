package com.example.app

fun main() {
    var totalPrice = run {
        var computer = 10000
        var mouse = 5000
        //run이라는 중괄호 영역에 computer과 mouse영역 임시 생성

        computer+mouse
        //computer과 mouse를 더한것를 totalPrice에 저장
    }
    println("총 가격은 ${totalPrice}입니다")
}
