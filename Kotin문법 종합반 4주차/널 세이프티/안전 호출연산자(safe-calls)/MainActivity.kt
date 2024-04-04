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
        //address에 서울을 저장하고 displayInfo하면 주소는 서울 입니다 까지 출력
    }

    fun displayAddressLength() {
        println("주소의 길이는: ${address?.length} 입니다")
        //참새까지 넣은 단계에 address를 넣지 않았기 때문에 "주소의 길이는: null 입니다"라고 출력
        //null 발생시에는 프로그램이 종료되지 않고 null이 아니면 호출되고 null이면 null입니라 라고 안전하게 호출
        //address?.length로 address길이 호출
        //address가 null인지 보고 null이면 호출하지 않고 null이 아니면 ddress?.length으로 하여 length길이 호출 
    }
}
