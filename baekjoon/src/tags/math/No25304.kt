package tags.math

/**
 * https://www.acmicpc.net/problem/25304
 */
fun main() {
    val x = readln().toInt()
    val n = readln().toInt()
    val sum = (1..n).sumOf {
        val (a, b) = readln().split(" ").map { it.toInt() }
        a * b
    }
    if (x == sum) {
        println("Yes")
    } else {
        println("No")
    }
}
