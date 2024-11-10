package tags.math

/**
 * https://www.acmicpc.net/problem/25425
 */
fun main() {
    val (n, m, a, k) = readln().split(" ").map { it.toLong() }
    val remainder = a - k
    println("${max(n, remainder)} ${min(m, remainder)}")
}

private fun max(n: Long, remainder: Long): Long {
    return if (remainder >= n - 1) {
        n
    } else {
        remainder + 1
    }
}

private fun min(m: Long, remainder: Long): Long {
    return (remainder + m - 1) / m + 1
}
