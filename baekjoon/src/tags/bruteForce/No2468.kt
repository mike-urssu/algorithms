package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2468
 */
private lateinit var map: Array<List<Int>>

fun main() {
    val n = readln().toInt()
    map = Array(n) { readln().split(" ").map { it.toInt() } }

    val maxHeight = map.flatMap { it }.max()
    val maxSafeArea = (0..maxHeight).maxOf { getSafeArea(n, it) }
    println(maxSafeArea)
}

private lateinit var isVisited: Array<BooleanArray>
private fun getSafeArea(n: Int, height: Int): Int {
    isVisited = Array(n) { BooleanArray(n) }
    var area = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] > height && !isVisited[i][j]) {
                dfs(n, i, j, height)
                area++
            }
        }
    }
    return area
}

private val xs = intArrayOf(0, 1, 0, -1)
private val ys = intArrayOf(-1, 0, 1, 0)
private fun dfs(n: Int, x: Int, y: Int, height: Int) {
    isVisited[x][y] = true
    for (i in 0 until 4) {
        val nextX = x + xs[i]
        val nextY = y + ys[i]
        if (isInBoundary(n, nextX, nextY) && !isVisited[nextX][nextY] && map[nextX][nextY] > height) {
            dfs(n, nextX, nextY, height)
        }
    }
}

private fun isInBoundary(n: Int, x: Int, y: Int) = x in (0 until n) && y in (0 until n)
