package com.example.app

// 부모 클래스 정의
open class Vehicle {
    open fun accelerate() {
        println("일반적인 방식으로 가속합니다.")
    }
}

// 자식 클래스 정의
class Car : Vehicle() {
    override fun accelerate() {
        println("차가 엔진을 이용하여 가속합니다.")
    }
}

class Bicycle : Vehicle() {
    override fun accelerate() {
        println("자전거는 힘을 다리로 가속합니다.")
    }
}

fun main() {
    // 부모 클래스의 인스턴스를 생성하고 메서드 호출
    val vehicle = Vehicle()
    vehicle.accelerate()

    // 자식 클래스의 인스턴스를 생성하고 메서드 호출
    val car = Car()
    val bicycle = Bicycle()
    car.accelerate()
    bicycle.accelerate()
}
