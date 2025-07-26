package tags.bfs

/**
 * https://www.acmicpc.net/problem/11123
 */
import java.util.LinkedList
import java.util.Queue

private var h = 0
private var w = 0
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln().split(" ").map { it.toInt() }
        h = input[0]
        w = input[1]
        graph = Array(h) { readln().toCharArray() }
        isVisited = Array(h) { BooleanArray(w) }
        println(count())
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun count(): Int {
    var count = 0
    (0 until h).forEach { i ->
        (0 until w).forEach { j ->
            if (!isVisited[i][j] && graph[i][j] == '#') {
                bfs(i, j)
                count++
            }
        }
    }
    return count
}

private fun bfs(i: Int, j: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(i to j)
    isVisited[i][j] = true

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == '#') {
                queue.add(nextX to nextY)
                isVisited[nextX][nextY] = true
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until h && y in 0 until w
