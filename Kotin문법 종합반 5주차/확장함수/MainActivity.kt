package com.example.app

fun main() {
    //확장함수
    fun Student.getGrade() = println("학생의 등급은 ${this.grade} 입니다")
    //getGrade호출하면 "학생의 등급은 ${this.grade} 입니다"를 출력
    var student = Student("참새", 10, "A+")
    student.displayInfo()
    student.getGrade()
    //displayInfo 종료 후 getGrade를 호출
}

class Student(name: String, age: Int, grade: String) {
    var name: String
    var age: Int
    var grade: String

    init {
        this.name = name
        this.age = age
        this.grade = grade
    }

    fun displayInfo() {
        println("이름은 ${name} 입니다")
        println("나이는 ${age} 입니다")
    }
}
