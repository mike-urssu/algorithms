package tags.dfs

/**
 * https://www.acmicpc.net/problem/1189
 */
private var r = 0
private var c = 0
private var k = 0
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>
private var count = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    k = input[2]
    graph = Array(r) { readln().toCharArray() }
    isVisited = Array(r) { BooleanArray(c) }

    isVisited[r - 1][0] = true
    dfs(r - 1, 0, 1)

    println(count)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun dfs(x: Int, y: Int, depth: Int) {
    if (depth == k) {
        if (x == 0 && y == c - 1) {
            count++
        }
        return
    }

    (0 until 4).forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == '.') {
            isVisited[nextX][nextY] = true
            dfs(nextX, nextY, depth + 1)
            isVisited[nextX][nextY] = false
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until r && y in 0 until c
