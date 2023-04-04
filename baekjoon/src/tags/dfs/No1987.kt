package tags.dfs

/**
 * https://www.acmicpc.net/problem/1987
 */
private lateinit var graph: Array<CharArray>
private val characters = mutableSetOf<Char>()
private var max = 1

fun main() {
    val (r, _) = readln().split(" ").map { it.toInt() }
    graph = Array(r) { readln().toCharArray() }

    dfs(0, 0)

    println(max)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private fun dfs(x: Int, y: Int) {
    characters.add(graph[x][y])
    max = max.coerceAtLeast(characters.size)

    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !characters.contains(graph[nextX][nextY])) {
            dfs(nextX, nextY)
            characters.remove(graph[nextX][nextY])
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
