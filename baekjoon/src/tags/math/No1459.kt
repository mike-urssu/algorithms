package tags.math

/**
 * https://www.acmicpc.net/problem/1459
 */
fun main() {
    val (x, y, w, s) = readln().split(" ").map { it.toLong() }
    val t = if (2 * w <= s) {
        (x + y) * w
    } else {
        val big = x.coerceAtLeast(y)
        val small = x.coerceAtMost(y)

        var sum = 0L
        sum += small * s
        sum += (big - small) / 2 * 2 * s.coerceAtMost(w)
        if ((big - small) % 2 == 1L) {
            sum += w
        }
        sum
    }
    println(t)
}
