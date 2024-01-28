package tags.implementation

/**
 * https://www.acmicpc.net/problem/15685
 */
import java.util.Stack

private val graph = Array(101) { BooleanArray(101) }

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (y, x, d, g) = readln().split(" ").map { it.toInt() }
        drawPath(x, y, d, g)
    }
    println(countRectangle())
}

private val dx = intArrayOf(0, -1, 0, 1)
private val dy = intArrayOf(1, 0, -1, 0)

private fun drawPath(x: Int, y: Int, d: Int, g: Int) {
    val paths = getPaths(d, g)
    var nextX = x
    var nextY = y
    graph[nextX][nextY] = true
    paths.forEach { i ->
        nextX += dx[i]
        nextY += dy[i]
        graph[nextX][nextY] = true
    }
}

private fun getPaths(d: Int, g: Int): List<Int> {
    val paths = mutableListOf<Int>()
    paths.add(d)
    repeat(g) {
        val nextPaths = Stack<Int>()
        nextPaths.addAll(paths)
        while (nextPaths.isNotEmpty()) {
            paths.add((nextPaths.pop() + 1) % 4)
        }
    }
    return paths
}

private fun countRectangle(): Int {
    var count = 0
    for (i in 0 until 100) {
        for (j in 0 until 100) {
            if (graph[i][j] && graph[i + 1][j] && graph[i][j + 1] && graph[i + 1][j + 1]) {
                count++
            }
        }
    }
    return count
}
