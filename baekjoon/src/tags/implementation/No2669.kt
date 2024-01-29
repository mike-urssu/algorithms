package tags.implementation

/**
 * https://www.acmicpc.net/problem/2669
 */
fun main() {
    val graph = Array(101) { IntArray(101) }
    repeat(4) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        (x1 until x2).forEach { i ->
            (y1 until y2).forEach { j ->
                graph[i][j] = 1
            }
        }
    }
    println(graph.sumOf { it.sum() })
}
