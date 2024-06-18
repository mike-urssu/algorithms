package tags.implementation

/**
 * https://www.acmicpc.net/problem/5354
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val graph = Array(n) { CharArray(n) { 'J' } }
        (0 until n).forEach { i ->
            graph[i][0] = '#'
            graph[i][n - 1] = '#'
        }
        (0 until n).forEach { j ->
            graph[0][j] = '#'
            graph[n - 1][j] = '#'
        }
        graph.forEach { println(it) }
        println()
    }
}
