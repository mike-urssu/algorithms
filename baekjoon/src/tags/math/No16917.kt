package tags.math

/**
 * https://www.acmicpc.net/problem/16917
 */
fun main() {
    val (a, b, c, x, y) = readln().split(" ").map { it.toInt() }
    val min = if (a + b > c * 2) {
        val min = x.coerceAtMost(y)
        var cost = min * c * 2
        cost += ((x - min) * a + (y - min) * b).coerceAtMost((x - min) * c * 2 + (y - min) * c * 2)
        cost
    } else {
        a * x + b * y
    }
    println(min)
}
