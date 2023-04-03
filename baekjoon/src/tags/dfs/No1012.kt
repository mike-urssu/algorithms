package tags.dfs

/**
 * https://www.acmicpc.net/problem/1012
 */
private lateinit var graph: Array<BooleanArray>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (m, n, k) = readln().split(" ").map { it.toInt() }
        graph = Array(n) { BooleanArray(m) }
        repeat(k) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            graph[y][x] = true
        }

        var count = 0
        for (i in graph.indices) {
            for (j in graph[i].indices) {
                if (graph[i][j]) {
                    dfs(i, j)
                    count++
                }
            }
        }
        println(count)
    }
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int) {
    graph[x][y] = false

    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY]) {
            dfs(nextX, nextY)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph.first().indices
