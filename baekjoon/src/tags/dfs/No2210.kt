package tags.dfs

/**
 * https://www.acmicpc.net/problem/2210
 */
private lateinit var graph: Array<IntArray>
private val set = mutableSetOf<String>()
private lateinit var string: StringBuilder

fun main() {
    graph = Array(5) { readln().split(" ").map { it.toInt() }.toIntArray() }

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            string = StringBuilder()
            dfs(i, j, string)
        }
    }

    println(set.size)
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int, s: StringBuilder) {
    if (s.length == 6) {
        set.add(s.toString())
        return
    }

    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY)) {
            s.append(graph[nextX][nextY])
            dfs(nextX, nextY, s)
            s.deleteCharAt(s.length - 1)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
