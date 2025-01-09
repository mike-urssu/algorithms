package tags.dfs

/**
 * https://www.acmicpc.net/problem/13565
 */
private var m = 0
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    graph = Array(m) { readln().map { it.digitToInt() }.toIntArray() }
    isVisited = Array(m) { BooleanArray(n) }

    (0 until n).forEach { y ->
        if (!isVisited[0][y] && graph[0][y] == 0) {
            isVisited[0][y] = true
            dfs(0, y)
        }
    }

    if (isVisited.last().any { it }) {
        println("YES")
    } else {
        println("NO")
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun dfs(x: Int, y: Int) {
    if (x == m - 1) {
        return
    }

    (0 until 4).forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 0) {
            isVisited[nextX][nextY] = true
            dfs(nextX, nextY)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until m && y in 0 until n
