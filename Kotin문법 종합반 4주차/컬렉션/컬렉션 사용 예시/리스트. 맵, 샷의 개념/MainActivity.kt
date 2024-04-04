package com.example.app

fun main() {
    // 리스트(List) 예시
    val numbersList = listOf(1, 2, 3, 4, 5)
    println("리스트: $numbersList")

    // 집합(Set) 예시
    val colorsSet = setOf("Red", "Green", "Blue", "Red")
    println("집합: $colorsSet")

    // 맵(Map) 예시
    val agesMap = mapOf("Alice" to 30, "Bob" to 25, "Charlie" to 35)
    println("맵: $agesMap")

    // 리스트 요소 접근
    println("첫 번째 요소: ${numbersList[0]}")
    println("마지막 요소: ${numbersList.last()}")

    // 집합 요소 추가
    val fruitsSet = mutableSetOf("Apple", "Banana")
    fruitsSet.add("Orange")
    println("수정된 집합: $fruitsSet")

    // 맵 요소 수정
    val agesMutableMap = mutableMapOf("Alice" to 30, "Bob" to 25, "Charlie" to 35)
    agesMutableMap["Alice"] = 31
    println("수정된 맵: $agesMutableMap")

    // 리스트 순회
    println("리스트 순회:")
    for (number in numbersList) {
        println(number)
    }
}
