package tags.implementation

/**
 * https://www.acmicpc.net/problem/16926
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    repeat(r) { rotate(n, m) }
    graph.forEach { println(it.joinToString(" ")) }
}

private fun rotate(n: Int, m: Int) {
    val min = minOf(n, m)
    for (k in 0 until min / 2) {
        val leftUp = graph[k][k]
        (k until m - 1 - k).forEach { j -> graph[k][j] = graph[k][j + 1] }
        (k until n - 1 - k).forEach { i -> graph[i][m - 1 - k] = graph[i + 1][m - 1 - k] }
        (m - 1 - k downTo 1 + k).forEach { j -> graph[n - 1 - k][j] = graph[n - 1 - k][j - 1] }
        (n - 1 - k downTo 1 + k).forEach { i -> graph[i][k] = graph[i - 1][k] }
        graph[k + 1][k] = leftUp
    }
}
