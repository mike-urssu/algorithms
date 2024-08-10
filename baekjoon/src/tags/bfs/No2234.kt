package tags.bfs

/**
 * https://www.acmicpc.net/problem/2234
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<Array<BooleanArray>>
private lateinit var isVisited: Array<BooleanArray>

private var rooms = 0
private var maxArea = 0
private var maxArea2 = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[1]
    m = input[0]
    graph = getGraph()

    bfs()
    bfs2()

    println(rooms)
    println(maxArea)
    println(maxArea2)
}

private fun getGraph(): Array<Array<BooleanArray>> {
    val graph = Array(n) { Array(m) { BooleanArray(4) } }
    (0 until n).forEach { i ->
        val numbers = readln().split(" ").map { it.toInt() }
        (0 until m).forEach { j ->
            (0 until 4).forEach { k ->
                graph[i][j][k] = numbers[j].and(1 shl k) != 0
            }
        }
    }
    return graph
}

private val dx = intArrayOf(0, -1, 0, 1)
private val dy = intArrayOf(-1, 0, 1, 0)

private fun bfs() {
    isVisited = Array(n) { BooleanArray(m) }
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (!isVisited[i][j]) {
                rooms++
                val size = countSize(i, j)
                maxArea = maxArea.coerceAtLeast(size)
            }
        }
    }
}

private fun bfs2() {
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            (0 until 4).forEach { k ->
                if (graph[i][j][k]) {
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY)) {
                        isVisited = Array(n) { BooleanArray(m) }
                        graph[i][j][k] = false
                        val count = countSize(i, j)
                        maxArea2 = maxArea2.coerceAtLeast(count)
                        graph[i][j][k] = true
                    }
                }
            }
        }
    }
}

private fun countSize(i: Int, j: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    var count = 1
    isVisited[i][j] = true
    queue.add(i to j)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        (0 until 4).forEach { k ->
            if (!graph[x][y][k]) {
                val nextX = x + dx[k]
                val nextY = y + dy[k]
                if (!isVisited[nextX][nextY]) {
                    count++
                    isVisited[nextX][nextY] = true
                    queue.add(nextX to nextY)
                }
            }
        }
    }
    return count
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
