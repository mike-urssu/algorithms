package tags.floyd_warshall

/**
 * https://www.acmicpc.net/problem/11265
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val times = getTimes(n)

    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (times[a][b] > c.toLong()) {
            println("Stay here")
        } else {
            println("Enjoy other party")
        }
    }
}

private fun getTimes(n: Int): Array<IntArray> {
    val times = Array(n + 1) { IntArray(n + 1) }
    (1..n).forEach { i -> readln().split(" ").map { it.toInt() }.toIntArray().copyInto(times[i], 1) }
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                times[i][j] = times[i][j].coerceAtMost(times[i][k] + times[k][j])
            }
        }
    }
    return times
}
