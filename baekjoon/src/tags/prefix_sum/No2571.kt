package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/2571
 */
fun main() {
    val n = readln().toInt()
    val points = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val graph = getGraph(points)

    var max = 0
    for (x1 in graph.indices) {
        for (y1 in graph[x1].indices) {
            for (x2 in x1 until graph.size) {
                for (y2 in y1 until graph[x1].size) {
                    if (!containsBlank(graph, x1, y1, x2, y2)) {
                        val area = (x2 - x1 + 1) * (y2 - y1 + 1)
                        max = max.coerceAtLeast(area)
                    }
                }
            }
        }
    }
    println(max)
}

private fun getGraph(points: Array<IntArray>): Array<IntArray> {
    val graph = Array(101) { IntArray(101) }
    points.forEach { point ->
        val x = point[0]
        val y = point[1]
        (y until y + 10).forEach { i ->
            (x until x + 10).forEach { j ->
                graph[i][j] = 1
            }
        }
    }
    return graph
}

private fun containsBlank(graph: Array<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return (x1..x2).any { x ->
        (y1..y2).any { y ->
            graph[x][y] == 0
        }
    }
}
