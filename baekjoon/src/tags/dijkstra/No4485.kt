package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/4485
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<IntArray>

fun main() {
    var index = 1
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }

        graph = getGraph(n)

        println("Problem ${index++}: ${getLeastRupee(n)}")
    }
}

private fun getGraph(n: Int) =
    Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getLeastRupee(n: Int): Int {
    val rupee = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val queue: Queue<Triple<Int, Int, Int>> = PriorityQueue { it, other ->
        it.third.compareTo(other.third)
    }

    rupee[0][0] = graph[0][0]
    queue.add(Triple(0, 0, rupee[0][0]))

    while (queue.isNotEmpty()) {
        val (x, y, r) = queue.poll()
        if (rupee[x][y] < r) {
            continue
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(n, nextX, nextY) && rupee[nextX][nextY] == Int.MAX_VALUE) {
                if (rupee[nextX][nextY] > rupee[x][y] + graph[nextX][nextY]) {
                    rupee[nextX][nextY] = rupee[x][y] + graph[nextX][nextY]
                    queue.add(Triple(nextX, nextY, rupee[nextX][nextY]))
                }
            }
        }
    }

    return rupee.last().last()
}

private fun isInBoundary(n: Int, x: Int, y: Int) =
    x in 0 until n && y in 0 until n
