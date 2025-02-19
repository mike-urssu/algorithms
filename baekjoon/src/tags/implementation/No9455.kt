package tags.implementation

/**
 * https://www.acmicpc.net/problem/9455
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
        var movement = 0
        (0 until m).forEach { j ->
            (n - 1 downTo 0).forEach { i ->
                if (graph[i][j] == 1) {
                    movement += drop(graph, n, i, j)
                }
            }
        }
        println(movement)
    }
}

private fun drop(graph: Array<IntArray>, n: Int, i: Int, j: Int): Int {
    var movement = 0
    for (h in i + 1 until n) {
        if (graph[h][j] == 1) {
            break
        }
        movement++
    }
    graph[i][j] = 0
    graph[i + movement][j] = 1
    return movement
}
