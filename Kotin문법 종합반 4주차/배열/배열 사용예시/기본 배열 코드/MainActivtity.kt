package com.example.app

fun main() {
    // 정수형 배열
    val numbers = arrayOf(1, 2, 3, 4, 5)
    println("정수형 배열: ${numbers.joinToString()}")

    // 문자열 배열
    val colors = arrayOf("Red", "Green", "Blue")
    println("문자열 배열: ${colors.joinToString()}")

    // 다차원 배열
    val matrix = Array(3) { Array(3) { 0 } }
    for (row in matrix) {
        for (element in row) {
            print("$element ")
        }
        println()
    }

    // 배열 요소 접근과 수정
    numbers[2] = 10
    println("수정된 정수형 배열: ${numbers.joinToString()}")

    // 배열 크기 확인
    println("정수형 배열의 크기: ${numbers.size}")

    // 배열 순회
    println("문자열 배열 순회:")
    for (color in colors) {
        println(color)
    }
}
