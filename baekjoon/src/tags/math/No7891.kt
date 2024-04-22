package tags.math

/**
 * https://www.acmicpc.net/problem/7891
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        println(x + y)
    }
}
