package tags.implementation

/**
 * https://www.acmicpc.net/problem/20001
 */
fun main() {
    readln()
    var questions = 0
    while (true) {
        val s = readln()
        if (s == "고무오리 디버깅 끝") {
            break
        }
        if (s == "문제") {
            questions++
        } else {
            if (questions == 0) {
                questions += 2
            } else {
                questions--
            }
        }
    }

    if (questions == 0) {
        println("고무오리야 사랑해")
    } else {
        println("힝구")
    }
}
