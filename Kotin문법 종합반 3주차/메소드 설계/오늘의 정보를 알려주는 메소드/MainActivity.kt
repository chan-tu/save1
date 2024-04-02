package com.example.app

fun main() {
    // displayInfo라는 이름의 메소드를 호출!
    displayInfo()
}
//파라미터안의 매개변수x
fun displayInfo() : Unit {
    println("오늘의 날씨는 화창합니다")
    println("오늘은 검정색을 조심하세요")
    //메소드 실행결과를 리턴할 때는 ': Unit'를 사용
    //': Unit' 명시할 필요가 없기 때문에 생략이 가능 
}
