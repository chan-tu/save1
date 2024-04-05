package com.example.app

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    //메인 쓰레드
    thread(start = true) {
        //첫번째 쓰레드
        for(i in 1..10) {
            //1 ~ 10까지 1초마다 쉬면서 진행
            println("Thread1: 현재 숫자는 ${i}")
            runBlocking {
                launch {
                    delay(1000)
                }
            }
        }
    }

    thread(start = true) {
        //두번쨰 쓰레드
        for(i in 50..60) {
            //50 ~ 60까지 1초마다 쉬면서 진행
            println("Thread2: 현재 숫자는 ${i}")
            runBlocking {
                launch {
                    delay(1000)
                }
            }
        }
    }
}
