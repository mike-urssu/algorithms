package tags.math

/**
 * https://www.acmicpc.net/problem/11312
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toLong() }
        println(a / b * a / b)
    }
}
