package com.example.app

fun main() {
    println("몇 마리를 생성하시겠습니까?")
    var count = readLine()!!.toInt() //마리 수 입력
    var birds = mutableListOf<Bird>()//수정가능한 리스트
    //birds는 Bird 클래스에 저장이 가능

    for(idx in 0..count-1) {
        //입력한 마리수 - 1
        println("조류의 이름을 입력해주세요")
        var name = readLine()!!//새 이름 입력

        // as Bird는 생략가능
        birds.add(Sparrow(name) as Bird)
        //as Bird는 업 캐스팅을 만든 겠다는 의미
        //birds.add에 Sparrow가 바로 넣을 수가 없기 때문에 as Bird로 업 캐스팅
        //as Bird로 업 캐스팅 한것으로 인해 Sparrow는 상속 관계에 있고 버드로서 버드 리스트에 저장되는 것이 가능
    }
    println("============조류 생성완료============")
    for(bird in birds) {
        //birds 리스트 안에 있는 것들을 하나씩 꺼내 bird.fly() 호출
        //이로인해 각각 저장되어있는 자식의 name이 호출
        bird.fly()
    }
}

open class Bird(name: String) {
    var name: String

    init {
        this.name = name
    }

    fun fly() {
        println("${name}이름의 조류가 날아요~")
    }//Sparrow가 Bird에게 상속받고 있기 떄문에 출력되는 정보
}

class Sparrow(name: String): Bird(name) {
    //Sparrow 클래스 객체 생성
    //생성자 name를 넘기고 상속 받은 Bird에 name를 넘김

}
