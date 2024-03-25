package tags.math

/**
 * https://www.acmicpc.net/problem/30031
 */
fun main() {
    val n = readln().toInt()
    val sum = (0 until n).sumOf {
        val (width, _) = readln().split(" ").map { it.toInt() }
        val cost = when (width) {
            136 -> 1000
            142 -> 5000
            148 -> 10000
            else -> 50000
        }
        cost
    }
    println(sum)
}
