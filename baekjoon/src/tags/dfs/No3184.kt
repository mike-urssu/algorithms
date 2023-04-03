package tags.dfs

private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>
private val validCharacters = setOf('.', 'o', 'v')
private var sheepInBoundary = 0
private var wolvesInBoundary = 0

/**
 * https://www.acmicpc.net/problem/3184
 */
fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    graph = Array(r) { readln().toCharArray() }
    isVisited = Array(r) { BooleanArray(c) }

    var sheep = 0
    var wolves = 0

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!isVisited[i][j] && graph[i][j] in validCharacters) {
                sheepInBoundary = 0
                wolvesInBoundary = 0

                dfs(i, j)

                if (sheepInBoundary > wolvesInBoundary) {
                    sheep += sheepInBoundary
                } else {
                    wolves += wolvesInBoundary
                }
            }
        }
    }

    println("$sheep $wolves")
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int) {
    isVisited[x][y] = true
    when (graph[x][y]) {
        'o' -> sheepInBoundary++
        'v' -> wolvesInBoundary++
    }

    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] in validCharacters) {
            dfs(nextX, nextY)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
