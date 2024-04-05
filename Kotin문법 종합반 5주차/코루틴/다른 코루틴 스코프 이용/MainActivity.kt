package com.example.app

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    println("메인쓰레드 시작")
    var job = CoroutineScope(Dispatchers.Default).launch {
    //CoroutineScope는 임시로 사용하 것이기 때문에 사용 종료 후 job을 캔슬하여 해제
        delay(3000)
        println("여기는 코루틴...")
    }
    runBlocking {
        job.join()
    }
    println("메인쓰레드 종료")
    job.cancel()
    //할당된 잡을 캔슬해서 해재
}
