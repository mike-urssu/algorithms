package tags.implementation

/**
 * https://www.acmicpc.net/problem/4396
 */
private var n = 0
private lateinit var graph: Array<CharArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().toCharArray() }
    val map = Array(n) { readln().toCharArray() }

    var isVisited = false
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 'x') {
                if (graph[i][j] == '.') {
                    map[i][j] = count(i, j).digitToChar()
                } else {
                    isVisited = true
                }
            }
        }
    }

    if (isVisited) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][j] == '*') {
                    map[i][j] = '*'
                }
            }
        }
    }
    map.forEach { println(it.joinToString("")) }
}

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

private fun count(x: Int, y: Int) =
    (0 until 8).count { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        isInBoundary(nextX, nextY) && graph[nextX][nextY] == '*'
    }

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
