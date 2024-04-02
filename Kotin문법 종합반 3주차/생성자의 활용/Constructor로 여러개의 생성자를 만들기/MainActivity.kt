package com.example.app

fun main() {

}

class Character {
    var name:String = ""
    var hairColor:String = ""
    var height:Double = 0.0
    var age:Int = 0
    var gender:String = ""

    // 명시적 생성자 (Constructor)
    // _name, _hairColor, _height와 같이 생성자에 변수를 넘기는 경우에 사용함
    constructor(_name:String, _hairColor:String, _height:Double) {
        println("${_name}을 생성자로 넘겼어요")
        println("${_hairColor}를 생성자로 넘겼어요")
        println("${_height}를 생성자로 넘겼어요")
    }
    // _name, _hairColor, _height, _age, _gender와 같이 생성자에 변수를 넘기는 경우에 사용함
    constructor(_name:String, _hairColor:String, _height:Double, _age:Int, _gender:String) {
        println("${_name}을 생성자로 넘겼어요")
        println("${_hairColor}를 생성자로 넘겼어요")
        println("${_height}를 생성자로 넘겼어요")
        println("${_age}를 생성자로 넘겼어요")
        println("${_gender}를 생성자로 넘겼어요")
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
