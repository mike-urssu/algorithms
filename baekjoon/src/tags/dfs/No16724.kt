package tags.dfs

/**
 * https://www.acmicpc.net/problem/16724
 */
private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>
private lateinit var cycles: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray() }
    cycles = Array(n) { IntArray(m) }

    var cycle = 0
    (0 until n).forEach { x ->
        (0 until m).forEach { y ->
            if (cycles[x][y] == 0) {
                dfs(x, y, ++cycle)
            }
        }
    }
    println(cycle)
}

private val directions = charArrayOf('U', 'L', 'D', 'R')
private val reversedDirections = charArrayOf('D', 'R', 'U', 'L')
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun dfs(x: Int, y: Int, cycle: Int) {
    cycles[x][y] = cycle

    (0 until 4).forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (isInBoundary(nextX, nextY) && cycles[nextX][nextY] == 0 && graph[nextX][nextY] == reversedDirections[k]) {
            dfs(nextX, nextY, cycle)
        }
    }

    val k = directions.indexOf(graph[x][y])
    val nextX = x + dx[k]
    val nextY = y + dy[k]

    if (cycles[nextX][nextY] == cycle) {
        return
    }

    cycles[nextX][nextY] = cycle
    dfs(nextX, nextY, cycle)
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
