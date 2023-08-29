package tags.bfs

/**
 * https://www.acmicpc.net/problem/1012
 */
import java.util.LinkedList
import java.util.Queue

private var m = 0
private var n = 0
private var k = 0

private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln().split(" ").map { it.toInt() }
        m = input[0]
        n = input[1]
        k = input[2]
        graph = getGraph(m, n, k)
        isVisited = Array(m) { BooleanArray(n) }

        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (graph[i][j] == 1 && !isVisited[i][j]) {
                    bfs(i, j)
                    count++
                }
            }
        }
        println(count)
    }
}

private fun getGraph(m: Int, n: Int, k: Int): Array<IntArray> {
    val graph = Array(m) { IntArray(n) }
    repeat(k) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        graph[x][y] = 1
    }
    return graph
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)

private fun bfs(x: Int, y: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    isVisited[x][y] = true
    queue.add(Pair(x, y))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until 4) {
            val nextX = p.first + dx[i]
            val nextY = p.second + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 1) {
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until m && y in 0 until n
