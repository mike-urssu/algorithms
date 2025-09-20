package tags.math

/**
 * https://www.acmicpc.net/problem/6591
 */
fun main() {
    while (true) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        if (n == 0 && k == 0) {
            break
        }
        println(combination(n, minOf(k, n - k)))
    }
}

private fun combination(n: Int, k: Int): Long {
    var v = 1L
    (1..k).forEach { i -> v = v * (n - k + i) / i }
    return v
}
