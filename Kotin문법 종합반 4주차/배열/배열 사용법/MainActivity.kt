package com.example.app

import java.util.Arrays

fun main(){
    // arrayOf메소드를 호출하면 배열을 리턴해줍니다
// 1,2,3,4,5 각각을 저장한 변수 5개를 배열형태로 arr에 저장합니다
    var arr = arrayOf(1,2,3,4,5)
    //arrayOf안에 1~5까지 또는 원하는 개수 만큼 값을 넣어 arr에 저장

// 배열요소를 모두 출력합니다
    println(Arrays.toString(arr))
    //Arrays는 사용자가 만든 클래스와 메소드가 아니고 java.util.Arrays안에 있는 메소드이므로 다른 패키지를 호출해야 함
    //.toString 파라미터로 어레이를 받아 println으로 출력

// 배열의 첫번째 요소에 저장된 값을 출력합니다
// var num1 = 1의 num1과 arr[0]은 동일합니다
// arr[0]은 하나의 변수로 취급할 수 있습니다
// arr은 0~4번방(인덱스)까지 접근할 수 있습니다
    println(arr[0])
    //0~4번까지 변수 저장
}
