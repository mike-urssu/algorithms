package tags.bfs

/**
 * https://www.acmicpc.net/problem/1245
 */
private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    isVisited = Array(n) { BooleanArray(m) }

    var top = 0
    (0 until n).forEach { x ->
        (0 until m).forEach { y ->
            if (!isVisited[x][y] && graph[x][y] != 0) {
                if (isTop(x, y)) {
                    top++
                }
            }
        }
    }
    println(top)
}

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

private fun isTop(x: Int, y: Int): Boolean {
    isVisited[x][y] = true
    var isTop = true

    (0 until 8).forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (isInBoundary(nextX, nextY)) {
            if (graph[x][y] < graph[nextX][nextY]) {
                isTop = false
            } else if (graph[x][y] == graph[nextX][nextY]) {
                if (!isVisited[nextX][nextY] && !isTop(nextX, nextY)) {
                    isTop = false
                }
            }
        }
    }

    return isTop
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
