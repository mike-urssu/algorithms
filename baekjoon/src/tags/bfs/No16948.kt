package tags.bfs

/**
 * https://www.acmicpc.net/problem/16948
 */
import java.util.PriorityQueue

private var n = 0
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    n = readln().toInt()
    val (r1, c1, r2, c2) = readln().split(" ").map { it.toInt() }
    isVisited = Array(n) { BooleanArray(n) }
    isVisited[r1][c1] = true

    val count = count(r1, c1, r2, c2)
    println(count)
}

private val dx = intArrayOf(-2, -2, 0, 0, 2, 2)
private val dy = intArrayOf(-1, 1, -2, 2, -1, 1)

private fun count(r1: Int, c1: Int, r2: Int, c2: Int): Int {
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }
    queue.add(Triple(r1, c1, 0))

    while (queue.isNotEmpty()) {
        val (x, y, c) = queue.poll()
        if (x == r2 && y == c2) {
            return c
        }
        for (k in 0 until 6) {
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                isVisited[nextX][nextY] = true
                queue.add(Triple(nextX, nextY, c + 1))
            }
        }
    }
    return -1
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
