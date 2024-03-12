package com.example.calculater_application_v2

class Calculator(private val operator:AbstractOperation){

    fun operate(num1:Int,num2:Int):Double{
        return operator.operate(num1,num2)
    }

}
