package com.example.app

fun main() {
    // 두 개의 Set 정의
    val set1 = setOf(1, 2, 3, 4, 5)
    val set2 = setOf(4, 5, 6, 7, 8)

    // 교집합 구하기
    val intersection = set1.intersect(set2)
    println("교집합: $intersection")

    // 합집합 구하기
    val union = set1.union(set2)
    println("합집합: $union")
}
