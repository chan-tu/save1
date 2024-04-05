package com.example.app

fun main() {
    var student = Student("참새", 10)

    var result = student?.also {
        it.age = 50
        //student?가 null이 아닐 때 also를 실행
        //중괄호 안에 it으로 넘김
        //student개체에 it.age 변수에 접근하여 50으로 바꾸고 result에 저장
        //age가 바뀐 새로운 student개체가 result에 저장
    }
    result?.displayInfo()
    //result가 displayInfo() 하면 '이름은 참새 입니다', '나이는 50 입니다'가 출력
    student.displayInfo()
    //result에서 받든 student에서 받는 출력결과는 동일
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
