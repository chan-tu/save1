// 인터페이스 정의
interface Shape {
    fun calculateArea(): Double
}

// 구현 클래스들
class Circle(val radius: Double) : Shape {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(val width: Double, val height: Double) : Shape {
    override fun calculateArea(): Double {
        return width * height
    }
}

fun main() {
    // 인터페이스를 구현한 클래스들의 인스턴스 생성
    val circle = Circle(5.0)
    val rectangle = Rectangle(4.0, 6.0)

    // 각 도형의 면적 계산 및 출력
    println("원의 면적: ${circle.calculateArea()}")
    println("사각형의 면적: ${rectangle.calculateArea()}")
}
