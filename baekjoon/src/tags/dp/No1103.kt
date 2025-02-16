package tags.dp

/**
 * https://www.acmicpc.net/problem/1103
 */
import kotlin.system.exitProcess

private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>
private lateinit var dp: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray() }
    isVisited = Array(n) { BooleanArray(m) }
    dp = Array(n) { IntArray(m) }

    isVisited[0][0] = true
    dp[0][0] = 1
    dfs(0, 0)
    println(dp.maxOf { it.max() })
}

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

private fun dfs(x: Int, y: Int) {
    val l = graph[x][y].digitToInt()
    for (k in 0 until 4) {
        val nextX = x + l * dx[k]
        val nextY = y + l * dy[k]
        if (isInBoundary(nextX, nextY)) {
            if (isVisited[nextX][nextY]) {
                println(-1)
                exitProcess(0)
            }

            if (dp[x][y] + 1 > dp[nextX][nextY]) {
                isVisited[nextX][nextY] = true
                dp[nextX][nextY] = dp[x][y] + 1
                dfs(nextX, nextY)
                isVisited[nextX][nextY] = false
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m && graph[x][y] != 'H'
