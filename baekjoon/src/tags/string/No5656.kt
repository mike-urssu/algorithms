package tags.string

/**
 * https://www.acmicpc.net/problem/5656
 */
fun main() {
    var i = 1
    while (true) {
        val input = readln().split(" ")
        val a = input[0].toInt()
        val op = input[1]
        val b = input[2].toInt()
        if (op == "E") {
            break
        }
        val isCorrect = when (op) {
            ">" -> a > b
            ">=" -> a >= b
            "<" -> a < b
            "<=" -> a <= b
            "==" -> a == b
            else -> a != b
        }
        println("Case ${i++}: $isCorrect")
    }
}
