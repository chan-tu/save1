package com.example.app

fun main() {
    var bird = Bird(readln().toString())//새
    var chicken = Chicken(readln().toString())//닭
    var sparrow = Sparrow(readln().toString())//참새
    var pigeon = Pigeon(readln().toString())//비둘기

    bird.fly()
    chicken.fly()
    sparrow.fly()
    pigeon.fly()
}

open class Bird(name:String) {
    //Bird라는 클래스를 주생성자를 이용하여 생성
    var name: String = ""

    init {
        // this는 현재 클래스의 상태변수를 의미합니다
        // var name: String = ""
        this.name = name
        //this.name는 'var name즉 프로포티의 네임을 의미
        //자식클래스에서 받은 닭을 this.name에 저장
    }

    fun fly() {
        println("${name} 날아요~")
    }

}

class Chicken(name: String) : Bird(name) {
//부모 클래스에 생성자 있기 때문에 부모 클래스를 호출할떄 그대로 같이 파라미터 값을 넘겨야함
//따라서 자식 클래스도 생성자로부터 파라미터를 받는 것이 가능
//인스턴스(main 함수)에서 자식클래스가 닭을 받고 부모 클래스에게 바로 전달
}

class Sparrow(name: String) : Bird(name) {

}

class Pigeon(name: String) : Bird(name) {

}
