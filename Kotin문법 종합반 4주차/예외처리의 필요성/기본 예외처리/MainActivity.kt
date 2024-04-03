package com.example.app

fun main() {
    val numerator = 10
    val denominator = 0

    try {
        val result = divide(numerator, denominator)
        println("나눗셈 결과: $result")
    } catch (e: ArithmeticException) {
        println("나눗셈 오류 발생: ${e.message}")
    } finally {
        println("나눗셈 연산 완료")
    }
}

fun divide(numerator: Int, denominator: Int): Int {
    if (denominator == 0) {
        throw ArithmeticException("0으로 나눌 수 없습니다.")
    }
    return numerator / denominator
}
