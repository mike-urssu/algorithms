package tags.dfs

/**
 * https://www.acmicpc.net/problem/2573
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    var year = 0
    while (getParts() == 1) {
        melt()
        year++
    }

    if (getParts() == 0) {
        year = 0
    }

    println(year)
}

private fun getParts(): Int {
    isVisited = Array(graph.size) { BooleanArray(graph.first().size) }
    var count = 0
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!isVisited[i][j] && graph[i][j] != 0) {
                dfs(i, j)
                count++
            }
        }
    }
    return count
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int) {
    isVisited[x][y] = true
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] != 0) {
            dfs(nextX, nextY)
        }
    }
}

private fun melt() {
    val meltedIceberg = getMeltedIceberg()
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            graph[i][j] = maxOf(graph[i][j] - meltedIceberg[i][j], 0)
        }
    }
}

private fun getMeltedIceberg(): Array<IntArray> {
    val meltedIceberg = Array(graph.size) { IntArray(graph.first().size) }
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (graph[i][j] != 0) {
                meltedIceberg[i][j] = getMeltedHeights(i, j)
            }
        }
    }
    return meltedIceberg
}

private fun getMeltedHeights(x: Int, y: Int): Int {
    var count = 0
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
            count++
        }
    }
    return count
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
