package com.example.app

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    println("메인쓰레드 시작")
    var job = GlobalScope.launch {
        delay(3000)
        println("여기는 코루틴...")
    }
    runBlocking {
        job.join()
    //runBlocking이 job이 종료될때까지 기다리겠다고 명시
    //안드로이드 앱에서는 runBlocking이 불필요
    }
    println("메인쓰레드 종료")
}
