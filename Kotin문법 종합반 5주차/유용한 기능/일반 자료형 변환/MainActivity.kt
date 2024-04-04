package com.example.app

fun main() {
    var num1 = 20
    var num2 = 30.2

    var num3 = num2.toInt()
    //num2에 저장된 실수를 toInt을 사용하여 실수에서 정수로 바꾸고 num3에 저장
    var num4 = num1.toDouble()
    //num1에 저장된 정수를 toDouble을 사용하여 정수에서 실수로 바꾸고 num4에 저장

    var strNum5 = "10"
    var strNum6 = "10.21"

    var num5 = Integer.parseInt(strNum5)
    //strNum5에 저장된 정수형태의 문자열을 숫자로 바꾸기위해 싱글턴으로 선언된 Integer라는 클래스에 parseInt라는 메소드를 호출하고
    //(strNum5)라는 파라미터 문자열 형태의 숫자를 던지면 숫자로 바꿔 리턴되어 num5에 저장
    var num6 = strNum6.toDouble()
    //strNum6에 저장된 실수 형태의 문자열을 .toDouble()를 사용하여 정수에서 실수로 바꿔 num6에 저장

    println("num3: $num3")
    println("num4: $num4")
    println("num5: $num5")
    println("num6: $num6")

}
