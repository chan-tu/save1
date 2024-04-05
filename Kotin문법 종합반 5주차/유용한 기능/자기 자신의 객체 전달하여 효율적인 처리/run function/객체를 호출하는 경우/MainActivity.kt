package com.example.app

fun main() {
    var student = Student("참새", 10)
    student?.run {
    //student가 null이 아닐때 run 실생
        displayInfo()
    }
}

class Student(name: String, age: Int) {
    var name: String
    var age: Int

    init {
        this.name = name
        this.age = age
    }

    fun displayInfo() {
        println("이름은 ${name} 입니다")
        println("나이는 ${age} 입니다")
    }
}
