package com.example.app

fun main(){
    var s = Student()
    s.name = "참새"
    s.address = "서울"
    s.displayInfo()
}

class Student {
    lateinit var name:String
    //name는 lateinit
    var address:String? = null
    //address는 String?f를 붙여 null를 저장
    //처음에는 address에 null를 저장했지만 저장값을 서울로 변경

    fun displayInfo() {
        println("이름은: ${name} 입니다")
        println("주소는: ${address} 입니다")
        //displayInfo으로 이름과 주소 정상 출력
    }
}
