package tags.math

/**
 * https://www.acmicpc.net/problem/11006
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val legs = m * 2 - n
        println("$legs ${(n - legs) / 2}")
    }
}
