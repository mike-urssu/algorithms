package tags.dp

/**
 * https://www.acmicpc.net/problem/9625
 */
fun main() {
    val k = readln().toInt()
    val counts = Array(2) { IntArray(46) }
    counts[0][0] = 1
    (1..45).forEach { i ->
        counts[1][i] = counts[0][i - 1]
        counts[0][i] += counts[1][i - 1]
        counts[1][i] += counts[1][i - 1]
    }
    println("${counts[0][k]} ${counts[1][k]}")
}
