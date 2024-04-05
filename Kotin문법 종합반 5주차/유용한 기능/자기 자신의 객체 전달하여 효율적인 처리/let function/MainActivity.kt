package com.example.app

fun main() {
    var strNum = "10"

    var result = strNum?.let {
        //strNum? : strNum에 저장된 값이 널인지 아닌지 검사
        //let를 이용하여 중괄호 안에서 it으로 strNum를 대신 사용
        // 중괄호 안에서는 it으로 활용함
        Integer.parseInt(it)
        //Integer.parseInt에 it를 넘겼을때 문자열 형태의 숫자를 실제 숫자로 바꿔 result에 저장하는 것이 가능
    }//let는 현재 자신의 객체를 it으로 넘겨 중괄호 안에서 처리하고 리턴하여 result에 저장하는 목적으로 사용

    println(result!! + 1)
    //result!!가 null이 아님을 보장해서 +1 실행하고 출력
}
