package com.example.app

class AccessTestChildClass: AccessTestClass() {

    fun protectedTest1() {
        println("e의 값은 ${e}")
    }
}
