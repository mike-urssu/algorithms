package tags.bfs

/**
 * https://www.acmicpc.net/problem/16929
 */
import kotlin.system.exitProcess

private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray() }
    isVisited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j]) {
                dfs(i, j, i, j, 1)
                isVisited[i][j] = true
            }
        }
    }
    println("No")
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun dfs(srcX: Int, srcY: Int, x: Int, y: Int, depth: Int) {
    isVisited[x][y] = true
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (
            isInBoundary(nextX, nextY)
            && graph[srcX][srcY] == graph[nextX][nextY]
        ) {
            if (!isVisited[nextX][nextY]) {
                dfs(srcX, srcY, nextX, nextY, depth + 1)
            } else if (srcX == nextX && srcY == nextY && depth >= 4) {
                println("Yes")
                exitProcess(0)
            }
        }
    }
    isVisited[x][y] = false
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
