package tags.dp

/**
 * https://www.acmicpc.net/problem/14430
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    (1 until n).forEach { i -> graph[i][0] += graph[i - 1][0] }
    (1 until m).forEach { j -> graph[0][j] += graph[0][j - 1] }
    (1 until n).forEach { i ->
        (1 until m).forEach { j ->
            graph[i][j] += maxOf(graph[i - 1][j], graph[i][j - 1])
        }
    }
    println(graph[n - 1][m - 1])
}
