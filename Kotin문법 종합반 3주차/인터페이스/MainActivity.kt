package com.example.app

fun main() {
    var bird = Bird(readln().toString())//새
    var chicken = Chicken(readln().toString())//닭
    var sparrow = Sparrow(readln().toString())//참새
    var pigeon = Pigeon(readln().toString())//비둘기
    var duck = Duck(readln().toString())//오리

    bird.fly()
    chicken.fly()
    sparrow.fly()
    pigeon.fly()
    duck.swim()
    //duck는 swim라는 메소드를 추가 가능
}

open class Bird(name:String) {
    var name: String = ""

    init {
        // this는 현재 클래스의 상태변수를 의미합니다
        // var name: String = ""
        this.name = name
    }

    fun fly() {
        println("${name} 날아요~")
    }

}

class Chicken(name: String) : Bird(name) {

}

class Sparrow(name: String) : Bird(name) {

}

class Pigeon(name: String) : Bird(name) {

}

class Duck(name: String) : Bird(name), WaterBirdBehavior {//상속 클래스 이름.인터페이스 이름
    //상속는 다른 클래스과 동일하지만 대신에 WaterBirdBehavior라는 인터페이스가 추가
    override fun swim() {
        println("${name}가 수영해요~")
    }//swim라는 메소드를 오버라이딩 가능
}
