package tags.implementation

/**
 * https://www.acmicpc.net/problem/16433
 */
fun main() {
    val (n, r, c) = readln().split(" ").map { it.toInt() }
    val check = (r + c) % 2
    val graph = Array(n) { CharArray(n) { '.' } }
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if ((i + j) % 2 == check) {
                graph[i][j] = 'v'
            }
        }
    }
    graph.forEach { println(it.joinToString("")) }
}
