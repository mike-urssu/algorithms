package tags.math

/**
 * https://www.acmicpc.net/problem/9085
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val numbers = readln().split(" ").map { it.toInt() }
        println(numbers.sum())
    }
}
