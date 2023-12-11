package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/1629
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }
    println(pow(a, b, c))
}

private fun pow(a: Long, b: Long, c: Long): Long {
    if (b == 1L) {
        return a % c
    }

    val halfPow = pow(a, b / 2, c)
    return if (b % 2 == 0L) {
        halfPow * halfPow % c
    } else {
        (halfPow * halfPow % c) * a % c
    }
}
