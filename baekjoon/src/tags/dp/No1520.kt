package tags.dp

/**
 * https://www.acmicpc.net/problem/1520
 */
private var m = 0
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var dp: Array<IntArray>

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    m = numbers[0]
    n = numbers[1]
    graph = Array(m) { readln().split(" ").map { it.toInt() }.toIntArray() }
    dp = Array(m) { IntArray(n) { -1 } }
    println(findPath(0, 0))
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun findPath(x: Int, y: Int): Int {
    if (x == m - 1 && y == n - 1) {
        return 1
    }
    if (dp[x][y] != -1) {
        return dp[x][y]
    }
    dp[x][y] = 0
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[x][y] > graph[nextX][nextY]) {
            dp[x][y] += findPath(nextX, nextY)
        }
    }
    return dp[x][y]
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until m && y in 0 until n
