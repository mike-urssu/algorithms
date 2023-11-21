package tags.math

/**
 * https://www.acmicpc.net/problem/13241
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    println(a / getGCD(a, b) * b)
}

private fun getGCD(a: Long, b: Long): Long {
    return if (b == 0L) {
        a
    } else {
        getGCD(b, a % b)
    }
}
