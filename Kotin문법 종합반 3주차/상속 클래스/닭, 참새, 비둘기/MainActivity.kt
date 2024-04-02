package com.example.app

fun main() {
    var bird = Bird()
    var chicken = Chicken()
    var sparrow = Sparrow()
    var pigeon = Pigeon()
    //인스턴스 함수

    bird.fly()
    chicken.fly()
    sparrow.fly()
    pigeon.fly()
}

open class Bird {
    //Bird가 하위 클래스들에게 상속받게 하려면 open를 줘야함
    fun fly() {
        println("새는 날아요~")
    }
    //fly라는 함수과 메소드를 따로 만들지 않아도 자식 클래스가 부모클래스에 그대로 받을 수 있기 때문에 어디서든 사용이 가능
}

class Chicken : Bird() {
    //원래는 Bird 없이 Chicken만들고 fun를 만들어야 되지만 현재는 따로따로 만드는 것이 아니라 새라는 부모를 연결시켜 주기 위해 하는 것
    //Chicken는 Bird 클래스를 상속
    //bird가 부모이고 Chicken이 자식

}

class Sparrow : Bird() {
    //bird가 부모이고 Sparrow이 자식

}

class Pigeon : Bird() {
    //bird가 부모이고 Pigeon이 자식

}//자식클래의 부모가 누군지 알수 있다는 장점
