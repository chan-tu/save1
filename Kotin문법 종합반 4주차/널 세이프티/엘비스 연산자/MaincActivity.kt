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
        println("주소의 길이는: ${address?.length ?: "초기화하세요"} 입니다")
    }//'address?.length ?:'으로 null이면 null대신 초기화하세요가 출력
}
