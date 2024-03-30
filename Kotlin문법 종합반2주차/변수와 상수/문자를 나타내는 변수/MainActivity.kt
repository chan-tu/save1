package com.example.practice

fun main(){
// var one1:Char = '김'
// var 변수이름:타입(생략가능) = 값
    var one1 = '김' //변수 이름 'var'에 자료형 'one1'를 선언하여 문자열 '김'를 저장
    println("내 첫변수 one1 변수에는 ${one1}이 들어있어")//'one1'에 저장된 값 출력

    one1 = '나' // one1변수에 들어있던 '김' 대신에 '나'를 대입
    println("변경한 변수 one1 변수에는 ${one1}가 들어있어")//'one1'에 바뀐 값 출력
}
