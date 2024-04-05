package tags.bfs

/**
 * https://www.acmicpc.net/problem/1303
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0

private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]

    graph = Array(n) { readln().toCharArray() }

    val white = getPower('W')
    val blue = getPower('B')
    println("$white $blue")
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun getPower(color: Char): Int {
    var power = 0
    isVisited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j] && graph[i][j] == color) {
                var count = 1
                isVisited[i][j] = true
                val queue: Queue<Pair<Int, Int>> = LinkedList()
                queue.add(i to j)

                while (queue.isNotEmpty()) {
                    val (x, y) = queue.poll()
                    for (k in 0 until 4) {
                        val nextX = x + dx[k]
                        val nextY = y + dy[k]
                        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == color) {
                            count++
                            isVisited[nextX][nextY] = true
                            queue.add(nextX to nextY)
                        }
                    }
                }

                power += count * count
            }
        }
    }
    return power
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
