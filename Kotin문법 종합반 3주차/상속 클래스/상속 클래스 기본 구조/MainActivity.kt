// 부모 클래스 정의
open class Animal(val name: String) {
    open fun makeSound() {
        println("$name 가 소리를 냅니다.")
    }
}

// 자식 클래스 정의
class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name 가 멍멍 짖습니다.")
    }
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name 가 야옹 웁니다.")
    }
}

fun main() {
    // 부모 클래스의 인스턴스 생성
    val animal = Animal("동물")
    animal.makeSound()

    // 자식 클래스의 인스턴스 생성
    val dog = Dog("멍멍이")
    val cat = Cat("야옹이")
    dog.makeSound()
    cat.makeSound()
}
