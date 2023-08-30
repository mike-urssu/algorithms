package tags.bfs

/**
 * https://www.acmicpc.net/problem/10026
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0

private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().toCharArray() }
    val nonRedGreen = countNonRedGreen()
    val redGreen = countRedGreen()
    println("$nonRedGreen $redGreen")
}

private fun countNonRedGreen(): Int {
    isVisited = Array(n) { BooleanArray(n) }
    var count = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!isVisited[i][j]) {
                bfs(i, j, charArrayOf(graph[i][j]))
                count++
            }
        }
    }
    return count
}

private fun countRedGreen(): Int {
    isVisited = Array(n) { BooleanArray(n) }
    var count = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!isVisited[i][j]) {
                if (graph[i][j] in charArrayOf('R', 'G')) {
                    bfs(i, j, charArrayOf('R', 'G'))
                } else {
                    bfs(i, j, charArrayOf('B'))
                }
                count++
            }
        }
    }
    return count
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs(x: Int, y: Int, colors: CharArray) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(x, y))
    isVisited[x][y] = true

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until 4) {
            val nextX = p.first + dx[i]
            val nextY = p.second + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] in colors) {
                queue.add(Pair(nextX, nextY))
                isVisited[nextX][nextY] = true
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
