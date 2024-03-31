package com.example.practice

fun main(){
    var catStatus = false
    println("고양이는 매우 배고픕니다..")
    println("사료를 10번 먹여주세요")


    // 고양이가 현재 배고프니까(false) 사료 배급가능
    if(catStatus == false) {
        for(idx in 0..9) {
            ///0~9까지 반복하겠다는 의미
            println("${idx}번째: 냠냠")
        }
    }

    // 사료를 10번 준 이후의 상태변화
    catStatus = true
    if(catStatus == true) {
        println("배부른 고양이입니다")
    }
}
