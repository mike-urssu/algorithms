package tags.math

/**
 * https://www.acmicpc.net/problem/33964
 */
fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    println("1".repeat(x).toInt() + "1".repeat(y).toInt())
}
