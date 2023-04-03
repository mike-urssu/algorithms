package tags.dfs

/**
 * https://www.acmicpc.net/problem/2667
 */
private lateinit var graph: Array<CharArray>
private val houses = mutableListOf<Int>()
private var count = 0

fun main() {
    val n = readln().toInt()
    graph = Array(n) { readln().toCharArray() }

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (graph[i][j] == '1') {
                count = 0
                dfs(i, j)
                houses.add(count)
            }
        }
    }

    println(houses.size)
    houses.sorted().forEach { println(it) }
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int) {
    graph[x][y] = '0'
    count++

    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == '1') {
            dfs(nextX, nextY)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
