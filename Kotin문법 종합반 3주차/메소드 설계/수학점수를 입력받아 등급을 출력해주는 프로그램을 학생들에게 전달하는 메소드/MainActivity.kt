package com.example.app

fun main() {
    var myMathScore = readLine()!!.toInt()

    var myRank = checkRank(myMathScore)
    //checkRank메소드에서 실행하고 리턴한 값이 myRank에 저장
    println("나의 등급은 : ${myRank}")
}
//checkRank메소드 호출
//score에 입력한 점수 넘김
fun checkRank(score:Int) : String {
    return when(score) {
        in 90..100 ->	return "A"
        in 80..89 -> return "B"
        in 70..79 -> return "C"
        else -> return "D"
    }
}
//    Kotlin 컨벤션을 따르지 않은 형태
//    if(score >= 90) {
//        return "A"
//    } else if(score >= 80) {
//        return "B"
//    } else if(score >= 70) {
//        return "C"
//    } else {
//        return "D"
//    }
// }
