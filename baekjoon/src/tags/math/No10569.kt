package tags.math

/**
 * https://www.acmicpc.net/problem/10569
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (v, e) = readln().split(" ").map { it.toInt() }
        println(2 - v + e)
    }
}
