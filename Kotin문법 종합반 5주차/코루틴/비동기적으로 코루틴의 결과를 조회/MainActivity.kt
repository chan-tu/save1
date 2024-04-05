package com.example.app

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    println("메인쓰레드 시작")
    var job = GlobalScope.launch {
        //GlobalScope라는 전역적인 공간에 딜레이 3초주고 코루틴 실행
        delay(3000)
        println("여기는 코루틴...")
    }//백그라운드에서 비동기적으로 수행되는 것
    runBlocking {
        job.join()
    }//안드로이드 앱같은 경우 메인이 한번 실행되면 앱이 화면에 계속 떠 있고 앱은 죽지 않음
    println("메인쓰레드 종료")
    //안드로이드에서 이 코드를 똑같이 실행하면 똑같이 나옴
}
