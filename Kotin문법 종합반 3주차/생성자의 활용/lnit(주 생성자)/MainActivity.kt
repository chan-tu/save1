package com.example.app

fun main() {

}

// 클래스 선언부에 생성자를 명시함
class Character(_name:String, _hairColor:String, _height:Double) {
    //클래스를 실체하기 위해 이름, 머리색상, 키를 파라미터로 넘기고 셋팅
    var name:String = ""
    var hairColor:String = ""
    var height:Double = 0.0

    // 매개변수를 직접 넘기지않음
    init {
        println("매개변수없는 생성자 실행 완료!")
    }//주 생성자
    //class Character가 실체화될때 실행되는 코드
    //메모리에 올리기전 설계도를 바탕으로 캐릭터 하나가 찍어낼 떄 항상 최초로 실행되는 코드

    fun fireBall() {
        println("파이어볼!")
    }
    fun compositing(device1:String, device2:String): String {
        var device3 = device1 + device2
        println("새로운 무기인 ${device3}입니다")
        return device3
    }
}
