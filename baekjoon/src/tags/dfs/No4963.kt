package tags.dfs

/**
 * https://www.acmicpc.net/problem/4963
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    while (true) {
        val line = readln()
        if (line == "0 0") {
            break
        }

        val (w, h) = line.split(" ").map { it.toInt() }
        graph = Array(h) { readln().split(" ").map { it.toInt() }.toIntArray() }
        isVisited = Array(h) { BooleanArray(w) }
        var island = 0

        for (i in graph.indices) {
            for (j in graph[i].indices) {
                if (!isVisited[i][j] && graph[i][j] == 1) {
                    dfs(i, j)
                    island++
                }
            }
        }

        println(island)
    }
}

private val dx = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
private val dy = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private fun dfs(x: Int, y: Int) {
    isVisited[x][y] = true
    for (i in 0 until 8) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 1) {
            dfs(nextX, nextY)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
