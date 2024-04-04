package com.example.app

fun main() {
    // 읽기전용 맵입니다(mapOf)
    // 변수명[키]로 데이터에 접근할 수 있습니다
    var scoreInfo1 = mapOf("kor" to 94, "math" to 90, "eng" to 92)
    println(scoreInfo1["kor"])
    //scoreInfo1으로 키의 값 출력
    //kor에 94가 매핑되어있기 떄문에 94가 처음으로 출력

    // 수정가능 맵입니다(mutableMapOf)
    // 변수명[키]로 데이터에 접근할 수 있습니다
    var scoreInfo2 = mutableMapOf("kor" to 94, "math" to 90)
    scoreInfo2["eng"] = 92
    //eng를 추가로 넣어 scoreInfo2에 92저장
    println(scoreInfo2["eng"])

    // 맵의 키와 값을 동시에 추출해서 사용할 수 있습니다
    for((k,v) in scoreInfo2) {
        println("${k}의 값은 ${v}입니다")
        //인하고 맵 볍수를 넣으면 프로그램이 알아서 차곡차곡 하나씩 키와 값을 묶어 리턴을 하고
        //키에는 k 벨류에는 v가 들어가 println으로 출력이 가능
    }
}
