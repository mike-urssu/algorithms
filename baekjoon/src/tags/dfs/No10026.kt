package tags.dfs

/**
 * https://www.acmicpc.net/problem/10026
 */
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val n = readln().toInt()
    graph = Array(n) { readln().toCharArray() }

    isVisited = Array(n) { BooleanArray(n) }
    val count1 = countRGB()

    isVisited = Array(n) { BooleanArray(n) }
    val count2 = countNonRGB()

    println("$count1 $count2")
}

private fun countRGB(): Int {
    var count = 0
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!isVisited[i][j]) {
                dfs(i, j, listOf(graph[i][j]))
                count++
            }
        }
    }
    return count
}

private fun countNonRGB(): Int {
    var count = 0
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!isVisited[i][j]) {
                when (graph[i][j]) {
                    'R', 'G' -> dfs(i, j, listOf('R', 'G'))
                    'B' -> dfs(i, j, listOf('B'))
                }
                count++
            }
        }
    }
    return count
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int, colors: List<Char>) {
    isVisited[x][y] = true
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] in colors) {
            dfs(nextX, nextY, colors)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
