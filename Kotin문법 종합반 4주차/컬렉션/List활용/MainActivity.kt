package com.example.app

fun main() {
    // 읽기전용 리스트입니다(listOf)
// 0번, 1번, 2번 인덱스에 접근해서 값을 변경할 수 없습니다
    var scores1 = listOf(값1, 값2, 값3)

// 수정가능 리스트입니다(mutableListOf)
// 0번, 1번, 2번 인덱스에 접근해서 값을 변경할 수 있습니다
    var scores2 = mutableListOf(값1, 값2, 값3)
    scores2.set(인덱스, 값)
    //scores2.set(인덱스, 값)메소드를 호출하여 몇번쨰 인덱스에 무슨 값을 바꾸는것이 가능

// 수정가능 리스트입니다(ArrayList)
// 0번, 1번, 2번 인덱스에 접근해서 값을 변경할 수 있습니다
// array로 데이터들을 저장하는 ArrayList도 mutableListOf와 동일하게 사용할 수 있어요
// 저장할 데이터의 자료형을 < > 안에 지정해야 사용할 수 있어요
    var scores3 = ArrayList<자료형>(값1, 값2, 값3)
    //ArrayList는 내부에 데이터들을 저장할때 배열 형태로 차곡차곡 저장하기 떄문에 실제로 코딩할 때 Array를 많이 사용
    scores3.set(인덱스, 값)
}
