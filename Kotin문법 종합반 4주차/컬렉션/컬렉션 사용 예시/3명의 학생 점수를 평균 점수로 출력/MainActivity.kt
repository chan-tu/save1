package com.example.app

fun main() {
    var students = mutableListOf<Student>()//수정 가능한 리스트
    var averages = mutableMapOf<String, Int>()//수정 가능한 맵

    for(idx in 0..2) {
        println("학생의 이름을 입력하세요")
        var name = readLine()!!

        println("국어 점수를 입력하세요")
        var kor = readLine()!!.toInt()

        println("수학 점수를 입력하세요")
        var math = readLine()!!.toInt()

        println("영어 점수를 입력하세요")
        var eng = readLine()!!.toInt()
        //동적으로 학생 정보 입력

        var average = (kor + math + eng) / 3
        var tempStudent = Student(name, kor, math, eng)
        //학생 정보를 Student 클래스의 객체로 만들고 인스턴스 화

        students.add(tempStudent)
        //students 리스트에 동적으로 add에 추가
        averages[name] = average
        //averages는 사람 이름을 키값으로 해서 평균 점수 저장
    }

    for(student in students) {
        //students 리스트에 하나씩 꺼내 그 사람의 평균점수 출력
        var average = averages[student.name]
        student.displayInfo()
        println("평균점수는 ${average} 입니다")
    }
}

class Student(name:String, kor:Int, math:Int, eng:Int) {
    //(name:String, kor:Int, math:Int, eng:Int): 주 생성자
    var name:String
    var kor:Int
    var math:Int
    var eng:Int

    init {
        this.name = name
        this.kor = kor
        this.math = math
        this.eng = eng
    }//주 생성자을 통해 값들을 받아 세팅

    fun displayInfo() {
        println("이름: $name")
        println("국어: $kor")
        println("수학: $math")
        println("영어: $eng")
    }
}
