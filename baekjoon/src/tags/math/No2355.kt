package tags.math

/**
 * https://www.acmicpc.net/problem/2355
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }.sorted()
    val sum = if (b >= 0) {
        if (a >= 0) {
            sum(b) - sum(a - 1)
        } else {
            sum(b) - sum(-a)
        }
    } else {
        -(sum(-a) - sum(-b - 1))
    }
    println(sum)
}

private fun sum(n: Long) =
    n * (n + 1) / 2
