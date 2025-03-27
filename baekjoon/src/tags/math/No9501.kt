package tags.math

/**
 * https://www.acmicpc.net/problem/9501
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, d) = readln().split(" ").map { it.toInt() }
        val count = (0 until n).count {
            val (v, f, c) = readln().split(" ").map { it.toDouble() }
            d.toDouble() <= v * f / c
        }
        println(count)
    }
}
