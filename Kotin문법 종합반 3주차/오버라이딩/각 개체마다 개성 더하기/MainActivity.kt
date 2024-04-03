package com.example.app

fun main() {
    var bird = Bird(readln().toString())//새
    var chicken = Chicken(readln().toString(), readln().toInt())//닭, 2
    var sparrow = Sparrow(readln().toString(), readln().toString())//참새, 갈색검
    var pigeon = Pigeon(readln().toString(), readln().toString())//비둘기, 서울

    bird.fly()
    chicken.fly()
    sparrow.fly()
    pigeon.fly()
}

open class Bird(name:String) {
    var name: String = ""

    init {
        // this는 현재 클래스의 상태변수를 의미합니다
        // var name: String = ""
        this.name = name
    }

    open fun fly() {
        println("${name}은 날아요~")
    }//fly 메소드 오버라이딩(재설계)

}

class Chicken(name: String, age: Int) : Bird(name) {
//Chicken는 주생성자로 name과 age를 받고 Bird에 name만 넘기기
    var age:Int = 0

    init {
        this.age = age
    }


    override fun fly() {
//        super객체는 부모의 객체를 의미하며 자동으로 생성됨
//        즉 부모객체의 fly메소드를 부르는 행위임
//        필요없으니 주석처리완료
//        super.fly()
        //super:내부적으로 상속을 받으면 자동으로 만들어지는 부모 객체
        println("${age}살의 ${name}가 날아봅니다~ 꼬끼오!")
    }//fly를 재설계하여 오버라이딩

}

class Sparrow(name: String, color: String) : Bird(name) {
    var color:String = ""

    init {
        this.color = color
    }

    override fun fly() {
//        super객체는 부모의 객체를 의미하며 자동으로 생성됨
//        즉 부모객체의 fly메소드를 부르는 행위임
//        필요없으니 주석처리완료
//        super.fly()
        println("${color}의 ${name}이 날아봅니다~ 짹짹!")
    }
}

class Pigeon(name: String, address: String) : Bird(name) {
    var address: String = ""

    init {
        this.address = address
    }

    override fun fly() {
//        super객체는 부모의 객체를 의미하며 자동으로 생성됨
//        즉 부모객체의 fly메소드를 부르는 행위임
//        필요없으니 주석처리완료
//        super.fly()
        println("${address} 살고있는 ${name}가 날아봅니다~ 구구!")
    }
}
