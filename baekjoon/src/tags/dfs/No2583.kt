package tags.dfs

/**
 * https://www.acmicpc.net/problem/2583
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var area = 0

fun main() {
    val (m, n, k) = readln().split(" ").map { it.toInt() }
    graph = Array(m) { IntArray(n) }
    isVisited = Array(m) { BooleanArray(n) }

    repeat(k) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        for (i in y1 until y2) {
            for (j in x1 until x2) {
                graph[i][j]++
            }
        }
    }

    val areas = mutableListOf<Int>()
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!isVisited[i][j] && graph[i][j] == 0) {
                area = 0
                dfs(i, j)
                areas.add(area)
            }
        }
    }
    println(areas.size)
    println(areas.sorted().joinToString(" "))
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int) {
    isVisited[x][y] = true
    area++

    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 0) {
            dfs(nextX, nextY)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
