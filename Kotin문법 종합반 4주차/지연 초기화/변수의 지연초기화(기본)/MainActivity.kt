package com.example.app

fun main(){
    var s1 = Student()
    //Student를만들고 s1에 주소 저장
    s1.name = readln().toString()
    //s1.name에 string 값 저장
    s1.displayInfo()

    s1.age = readln().toInt()
    //s1.age에 정수값 저장
    s1.displayInfo()
}

class Student {
    lateinit var name:String
    //lateinit를 붙이면 '='하고 초기화가 안되어 있어도 사용이 가능
    var age:Int = 0

    fun displayInfo() {
        println("이름은: ${name} 입니다.")
        //name 넣었을때 초기화 되어 displayInfo할때 name 출력
        println("나이는: ${age} 입니다.")

    }
}
