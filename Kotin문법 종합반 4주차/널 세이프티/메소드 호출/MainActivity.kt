package com.example.app

fun main(){
//  var data = readLine()!!.toInt()

    //절대 널이 아니라는 의미
    var inputData = readLine()!!
    //readLine라는 메소드를 호출하면 리턴을 해주는데 값이 널이 아니라는 의미의 '!'를 붙임
    var data = inputData.toInt()
    //이를 inputData에 저장하고 널 체크 없이(inputData는 널이 아니니까)toInt 실행
    println("Null아닌 값: ${data}")
    //null이 아닌 값인 데이터를 출력
}
