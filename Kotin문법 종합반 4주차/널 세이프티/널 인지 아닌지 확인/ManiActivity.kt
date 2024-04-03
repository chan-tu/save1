package com.example.app

fun main(){
    var s = Student()
    s.name = "참새"
    s.displayAddressLength()

    s.address = "서울"
    s.displayInfo()
}

class Student {
    lateinit var name:String
    var address:String? = null

    fun displayInfo() {
        println("이름은: ${name} 입니다")
        println("주소는: ${address} 입니다")
    }

    fun displayAddressLength() {
        println("주소의 길이는: ${address?.length} 입니다")
        //displayAddressLength()는 address길이 호출하는 메소드
        //address가
    }
}
