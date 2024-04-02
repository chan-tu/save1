package com.example.app

fun main() {

}

class Character {
    var name:String = ""
    var hairColor:String = ""
    var height:Double = 0.0
    //정보(프로퍼티)
    //클래스 자료형하고 변수명 선언할 때는 반드시 ':'를 붙일것

    fun fireBall() {
        println("파이어볼!")
    }//행위1(메소드)
    fun compositing(device1:String, device2:String): String {
        var device3 = device1 + device2
        println("새로운 무기인 ${device3}입니다")
        return device3
    }//행위2(메소드)
}
