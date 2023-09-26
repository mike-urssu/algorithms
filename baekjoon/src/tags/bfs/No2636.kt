package tags.bfs

/**
 * https://www.acmicpc.net/problem/2636
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val pieces = mutableListOf<Int>()
    pieces.add(getPieces())
    while (true) {
        melt()
        if (graph.all { row -> row.all { it == 0 } }) {
            break
        }
        pieces.add(getPieces())
    }

    println(pieces.size)
    println(pieces.last())
}

private fun melt() {
    val airs = getAirs()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1 && isMelting(airs, i, j)) {
                graph[i][j] = 0
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getAirs(): Array<BooleanArray> {
    val airs = Array(n) { BooleanArray(m) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0 && !airs[nextX][nextY]) {
                airs[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return airs
}

private fun isMelting(airs: Array<BooleanArray>, x: Int, y: Int): Boolean {
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && airs[nextX][nextY]) {
            return true
        }
    }
    return false
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m

private fun getPieces() =
    graph.sumOf { row -> row.count { it == 1 } }
