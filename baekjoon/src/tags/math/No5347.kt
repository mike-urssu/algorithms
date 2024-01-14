package tags.math

/**
 * https://www.acmicpc.net/problem/5347
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toLong() }
        println(a / gcd(a, b) * b)
    }
}

private fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) {
        a
    } else {
        gcd(b, a % b)
    }
}
