package tags.math

/**
 * https://www.acmicpc.net/problem/17427
 */
fun main() {
    val n = readln().toInt()
    println(g(n))
}

private fun g(n: Int) =
    (1..n).sumOf { ((n / it) * it).toLong() }
