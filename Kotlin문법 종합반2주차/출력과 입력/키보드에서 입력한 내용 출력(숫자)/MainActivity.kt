package com.example.practice

fun main(){
    val dataNumber = readLine()!!.toInt()//'readLine'에서 입력한 내용을 'toInt'로 해석하여 'dataNumber'에 저장
    val sum = dataNumber + 3//'dataNumber'에 저장된 내용을 3을 더하여 'sum'에 저장 
    println("입력은 ${dataNumber}인데 3을 더해서 ${sum }이예요!") //'println'에 'dataNumber'과 'sum' 출력
}
