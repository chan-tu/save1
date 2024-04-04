fun main() {
    var kors = arrayOf(90, 94, 96)
    for((idx, kor) in kors.withIndex()) {
        //kors.withIndex를 호출하면 위치정보와 값을 하나로 묶어서 리턴해 주는 형태
        //첫번째 : idx값
        //두번째 : kor(실제)값
        println("${idx}번째 국어 점수는 ${kor}입니다")
        //idx값을 println으로 0번째, 1번째 등의 국어 점수가 출력 
    }
}
