package com.example.app

fun main(){
    var s1 = Student()
    s1.name = "참새"
    s1.displayInfo()

    s1.age = 10
    s1.displayInfo()
}

class Student {
    lateinit var name:String
    var age:Int = 0

    fun displayInfo() {
        if(this::name.isInitialized) {
            //name는 클래스 내부에 '::'으로 접근해야 isInitialized를 호출이 가능
            //정말로 초기화 되었는지 확인하기 위해 isInitialized를 호출
            println("이름은: ${name} 입니다.")
            println("나이는: ${age} 입니다.")
            //true면 실행
            
        } else {
            println("name변수를 초기화해주세요.")
            //false면 코드 실행 불가
        }
    }//만일 초기화가 안되어 있는데 이 코드가 실행이 되면 그것은 예외가 발생되어 예외처리를 위해 try-catch가 실행되고 코드가 길어져 프로그램성능 성능 저하
    //하지만 isInitialized를 호출하여 검사하면 간결하게 코드 작성이 가능
}
