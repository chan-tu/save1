package com.example.practice

fun main(){
    //나이값 입력
    var baseAge = readln().toInt()
    var myAge = readln().toInt()
    var teacherAge = readln().toInt()
    var babyAge = readln().toInt()

    var isMyAgePass = myAge == baseAge
    var isTeacherAgePass = teacherAge == baseAge
    //연산자 '=='를 사용, 같으면 true 틀리면 fales
    var isBabyAgeNoPass = babyAge != baseAge //연산자 '!='를 사용, 다른면 true 같은면 false


    println("어서오세요~")
    println("이번 이벤트는 ${baseAge}살만 참여할 수 있습니다!")

    println("================신분증 검사중================")

    println("내 나이는 ${myAge}니까 ${isMyAgePass}다!")
    println("선생님 연세는 ${teacherAge}니까 ${isTeacherAgePass}네요.. 미안해요!")
    println("${babyAge}살은 참여할수 없는게 맞아요! ${isBabyAgeNoPass}")
}
