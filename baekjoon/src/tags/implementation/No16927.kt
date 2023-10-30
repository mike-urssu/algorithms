package tags.implementation

/**
 * https://www.acmicpc.net/problem/16927
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val min = n.coerceAtMost(m)
    for (depth in 0 until min / 2) {
        repeat(r % ((m + n - depth * 4) * 2 - 4)) {
            rotate(n, m, depth)
        }
    }

    graph.forEach { println(it.joinToString(" ")) }
}

private fun rotate(n: Int, m: Int, depth: Int) {
    val leftUp = graph[depth][depth]
    (depth until m - 1 - depth).forEach { j -> graph[depth][j] = graph[depth][j + 1] }
    (depth until n - 1 - depth).forEach { i -> graph[i][m - 1 - depth] = graph[i + 1][m - 1 - depth] }
    (m - 1 - depth downTo 1 + depth).forEach { j -> graph[n - 1 - depth][j] = graph[n - 1 - depth][j - 1] }
    (n - 1 - depth downTo 1 + depth).forEach { i -> graph[i][depth] = graph[i - 1][depth] }
    graph[depth + 1][depth] = leftUp
}
