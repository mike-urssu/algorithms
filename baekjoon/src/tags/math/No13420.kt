package tags.math

/**
 * https://www.acmicpc.net/problem/13420
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln().split(" ")
        val a = input[0].toLong()
        val b = input[2].toLong()
        val c = input[4].toLong()

        val isCorrect = when (input[1]) {
            "+" -> a + b == c
            "-" -> a - b == c
            "*" -> a * b == c
            else -> a / b == c
        }
        if (isCorrect) {
            println("correct")
        } else {
            println("wrong answer")
        }
    }
}
