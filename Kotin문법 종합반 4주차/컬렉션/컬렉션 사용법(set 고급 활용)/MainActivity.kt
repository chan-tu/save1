package com.example.app

fun main() {
    // 귀여운 새의 집합
    var birdSet = setOf("닭", "참새", "비둘기", "물오리")

    // 날수있는 새의 집합
    var flyBirdSet = setOf("참새", "비둘기", "까치")

    // 모든 새의 집합 union(합집합)
    var unionBirdSet = birdSet.union(flyBirdSet)
    //unionBirdSet는 birdSet과 flyBirdSet더한 것

    // 귀엽고 날수있는 새의 집합 intersect(교집합)
    var intersectBirdSet = birdSet.intersect(flyBirdSet)
    //intersectBirdSet는 birdSet과 flyBirdSet 겹친 것

    // 귀여운 새들중에서 날수없는 새의 조합 subtract (차집합)
    var subtractBirdSet = birdSet.subtract(flyBirdSet)
    //subtractBirdSet는 birdSet에서 flyBirdSet를 차감한 것

    println("=====합집합=====")
    println("모든 새의 집합 : ${unionBirdSet}")

    println("=====교집합=====")
    println("귀엽고 날수있는 새의 집합 : ${intersectBirdSet}")

    println("=====차집합=====")
    println("귀엽고 날수없는 새의 집합 : ${subtractBirdSet}")
}
