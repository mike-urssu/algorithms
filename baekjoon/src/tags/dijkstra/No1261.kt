package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1261
 */
import java.util.PriorityQueue
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    graph = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    println(getBricks())
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getBricks(): Int {
    val bricks = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val queue: Queue<Triple<Int, Int, Int>> = PriorityQueue { it, other ->
        it.third.compareTo(other.third)
    }

    bricks[0][0] = 0
    queue.add(Triple(0, 0, 0))

    while (queue.isNotEmpty()) {
        val (x, y, count) = queue.poll()
        if (bricks[x][y] > count) {
            continue
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && bricks[nextX][nextY] > bricks[x][y] + graph[nextX][nextY]) {
                bricks[nextX][nextY] = bricks[x][y] + graph[nextX][nextY]
                queue.add(Triple(nextX, nextY, count + 1))
            }
        }
    }

    return bricks.last().last()
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
