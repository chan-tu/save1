package com.example.app

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    println("메인쓰레드 시작")
    var job = CoroutineScope(Dispatchers.Default).launch {
        var fileDownloadCoroutine = async(Dispatchers.IO) {
            delay(10000)
            "파일 다운로드 완료"
            //Dispatchers.IO의 이유는 웹으로 부터 파일 다운로드하고 데이터베이스에 데이터를 또 가져오고 넣은 행위를 하기 위해 적합한 쓰레드 io 쓰레드 위에 포르틴을 돌림
        }
        var databaseConnectCoroutine = async(Dispatchers.IO) {
            delay(5000)
            "데이터베이스 연결 완료"
        }
        println("${fileDownloadCoroutine.await()}")
        println("${databaseConnectCoroutine.await()}")
    }//비동기적으로 실행된다는 의미
    runBlocking {
        job.join()
        //안드로이에는 불필요하지만 백그라운드의 결과를 보기위해 runBlocking으로 join놓고 비동기적 처리
    }//잡이 끝날 때까지 메인 스레드 기다림
    println("메인쓰레드 종료")
    job.cancel()
}
