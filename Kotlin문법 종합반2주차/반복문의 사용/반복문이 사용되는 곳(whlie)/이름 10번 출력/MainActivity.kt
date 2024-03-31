package com.example.practice

fun main(){
    var i = readln().toInt()

    while(i < 10) { // i가 10보다 클때까지 계속 실행
        println("${i}번째: 내 이름은 참새")
        i++//for 같은 경우에는 i를 상수로 자동설정했기 때문에 1증가가 안됬지만 while는 변수를 따로 만들어서 사용하고 있기 때문에 1 증가가 가능
    }
}
