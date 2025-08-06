package tags.math

/**
 * https://www.acmicpc.net/problem/14730
 */
fun main() {
    val n = readln().toInt()
    val sum = (0 until n).sumOf {
        val (c, k) = readln().split(" ").map { it.toInt() }
        c * k
    }
    println(sum)
}
