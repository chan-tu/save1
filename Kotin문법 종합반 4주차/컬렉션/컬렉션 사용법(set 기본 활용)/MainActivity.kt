package com.example.app

fun main() {
    //  읽기전용 Set입니다.(setOf)
    var birdSet = setOf("닭", "참새", "비둘기")

//  수정가능 Set입니다.( mutableBirdSet)
    var mutableBirdSet = mutableSetOf("닭", "참새", "비둘기")
    mutableBirdSet.add("꿩")
    mutableBirdSet.remove("꿩")
    println("집합의 크기는 ${birdSet.size} 입니다")
    //집합 변수.size를 하면 크기 리턴

    var findBird = readLine()!!
    //집합에 새가 존재하는지 확인
    //빨리 보기 위한 느낌표
    //꿩은 findBird에 저장

    if (birdSet.contains(findBird)) {
        //birdSet에 닭, 참새, 비둘기 저장
        //birdSet에 꿩이 들어있는지 contains라는 메인 소드로 검사
        println("${findBird} 종류는 존재합니다.")
        //꿩이 있으면 "${findBird} 종류는 존재합니다."가 출력
    } else {
        println("${findBird}는 존재하지 않습니다.")
        //꿩이 없으면 "${findBird}는 존재하지 않습니다."가 출력
    }
    //리스트나 맵을 이용하여 인덱스 정보를 활용한 탐색을 하지 않고 존재하는지만 보고 싶다면 셋을 활용하여 컨테이스로 금방 찾음
}
