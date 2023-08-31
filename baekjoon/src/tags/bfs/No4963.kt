package tags.bfs

/**
 * https://www.acmicpc.net/problem/4963
 */
import java.util.LinkedList
import java.util.Queue

private var w = 0
private var h = 0

private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    while (true) {
        val input = readln().split(" ").map { it.toInt() }
        w = input[0]
        h = input[1]
        if (w == 0 && h == 0) {
            break
        }

        graph = Array(h) { readln().split(" ").map { it.toInt() }.toIntArray() }
        isVisited = Array(h) { BooleanArray(w) }

        var count = 0
        for (i in 0 until h) {
            for (j in 0 until w) {
                if (graph[i][j] == 1 && !isVisited[i][j]) {
                    bfs(i, j)
                    count++
                }
            }
        }
        println(count)
    }
}

private val dx = intArrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
private val dy = intArrayOf(-1, 0, 1, 1, 1, 0, -1, -1)

private fun bfs(x: Int, y: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    isVisited[x][y] = true
    queue.add(Pair(x, y))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until 8) {
            val nextX = p.first + dx[i]
            val nextY = p.second + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 1 && !isVisited[nextX][nextY]) {
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until h && y in 0 until w
