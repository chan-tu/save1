package com.example.app

fun main() {
    var chicken = Chicken()
    var eggs = chicken.getThreeEggs()
    var listEggs = eggs.toList()

//    first, second, third로 관리
//    var firstEgg = eggs.first
//    var secondEgg = eggs.second
//    var eggTime = eggs.third

    // 리스트로 관리
    var firstEgg = listEggs[0]
    var secondEgg = listEggs[1]
    var eggTime = listEggs[2]

    println("달걀의 정보는 ${eggs} 입니다.")
    println("리스트 달걀의 정보는 ${listEggs} 입니다.")
    println("첫번째 달걀의 종류는 ${firstEgg} 입니다.")
    println("두번째 달걀의 종류는 ${secondEgg} 입니다.")
    println("달걀은 ${eggTime}에 나왔습니다.")
}

class Chicken {
    fun getTwoEggs(): Pair<String, String> {
        var eggs = Pair("달걀", "맥반석")
        return eggs
    }

    fun getThreeEggs(): Triple<String, String, Int> {
        //Piar에서 하나가 떠 늘어난 것 뿐으로 2개의 String과 하나의 Int으로 리턴
        var eggs = Triple("달걀", "맥반석", 20230101)
        return eggs
    }
}
