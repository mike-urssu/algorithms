package tags.math

/**
 * https://www.acmicpc.net/problem/1850
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    println("1".repeat(gcd(a, b).toInt()))
}

private fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) {
        a
    } else {
        gcd(b, a % b)
    }
}
