package tags.implementation

/**
 * https://www.acmicpc.net/problem/3023
 */
fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val graph = Array(2 * r) { CharArray(2 * c) }
    (0 until r).forEach { i -> readln().toCharArray().copyInto(graph[i]) }
    val (a, b) = readln().split(" ").map { it.toInt() - 1 }

    (0 until r).forEach { i ->
        (c until 2 * c).forEach { j ->
            graph[i][j] = graph[i][2 * c - j - 1]
        }
    }
    (r until 2 * r).forEach { i ->
        (0 until 2 * c).forEach { j ->
            graph[i][j] = graph[2 * r - i - 1][j]
        }
    }
    graph[a][b] = if (graph[a][b] == '.') {
        '#'
    } else {
        '.'
    }

    graph.forEach { println(it.joinToString("")) }
}
