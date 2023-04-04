package tags.dfs

/**
 * https://www.acmicpc.net/problem/1987
 */
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>
private val characters = mutableSetOf<Char>()
private var max = 1

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    graph = Array(r) { readln().toCharArray() }
    isVisited = Array(r) { BooleanArray(c) }

    isVisited[0][0] = true
    characters.add(graph[0][0])
    dfs(0, 0)

    println(max)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private fun dfs(x: Int, y: Int) {
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && !characters.contains(graph[nextX][nextY])) {
            isVisited[nextX][nextY] = true
            characters.add(graph[nextX][nextY])
            max = max.coerceAtLeast(characters.size)

            dfs(nextX, nextY)

            isVisited[nextX][nextY] = false
            characters.remove(graph[nextX][nextY])
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
