package com.example.app

class AccessTestClass {
    public var a: Int = 1
    //public는 있든 없는 상관 없는 키워드
    var b = 2
    private var c = 3
    //c는 동일한 클래스 내부에서만 접근이 가능하기 때문에 객체를 만들고 '객체 이름.c' 사용이 불가
    //AccessTestClass내에서만 사용이 가능하면 다른 클래스나 외부에서는 사용이 불가
    internal var d = 4
    //같은 모듈에 있기 때문에 접근이 가능
    protected var e = 5
    //e은 기본적으로 프라이빗이지만 상속관계에서만 사용이 가능
    //AccessTestClass를 상속 받았을 경우에만 사용이 가능

    public fun publicTest() {
        println("public 입니다")
    }

    fun publicTest2() {
        println("public 입니다")
    }

    private fun privateTest() {
        println("private 입니다")
    }

    internal fun internalTest() {
        println("internal 입니다")
    }

    protected fun protectedTest() {
        println("protected 입니다")
    }
}
