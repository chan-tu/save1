package com.example.app

fun main() {
    var alphabets = "abcd"

    with(alphabets) {
        //with에 알파벳 저장
        //중괄호 안에서 this 사용이 가능(생략도 가능
//      var result = this.subSequence(0,2)
        //this가 있을때 저장되는 result
        var result = subSequence(0,2)
        //thisrk 없을대 저장되는 result
        println(result)
    }
}
