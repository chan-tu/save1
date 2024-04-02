package com.example.app

fun main() {

}

class Character {
    //class Character를 실체화 하기 위해 name, hairColor, height 세가지 변수를 constructor에 넘김
    var name:String = ""
    var hairColor:String = ""
    var height:Double = 0.0

    // 명시적 생성자 (Constructor)
    // _name, _hairColor, _height와 같이 생성자에 변수를 넘기는 경우에 사용함
    constructor(_name:String, _hairColor:String, _height:Double) {
        //constructor라는 키워드에 name, hairColor, height 세가지 변수를 메소드 처럼 선언
        println("${_name}을 생성자로 넘겼어요")
        println("${_hairColor}를 생성자로 넘겼어요")
        println("${_height}를 생성자로 넘겼어요")
        //넘긴 값들을 최초로 출려하는 로직에 저장
    }

    fun fireBall() {
        println("파이어볼!")
    }
    fun compositing(device1:String, device2:String): String {
        var device3 = device1 + device2
        println("새로운 무기인 ${device3}입니다")
        return device3
    }
}
