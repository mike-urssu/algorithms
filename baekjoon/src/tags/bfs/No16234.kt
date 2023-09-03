package tags.bfs

/**
 * https://www.acmicpc.net/problem/16234
 */
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

private var n = 0
private var l = 0
private var r = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    l = input[1]
    r = input[2]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    var days = 0
    while (true) {
        val unions = mutableListOf<List<Pair<Int, Int>>>()
        isVisited = Array(n) { BooleanArray(n) }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!isVisited[i][j]) {
                    val union = getUnion(i, j)
                    if (union.size > 1) {
                        unions.add(union)
                    }
                }
            }
        }

        if (unions.isEmpty()) {
            break
        } else {
            move(unions)
            days++
        }
    }

    println(days)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getUnion(row: Int, col: Int): List<Pair<Int, Int>> {
    val union = mutableListOf<Pair<Int, Int>>()

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    union.add(Pair(row, col))
    isVisited[row][col] = true
    queue.add(Pair(row, col))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(x, y, nextX, nextY) && !isVisited[nextX][nextY]) {
                union.add(Pair(nextX, nextY))
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return union
}

private fun isInBoundary(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return x2 in 0 until n && y2 in 0 until n
            && abs(graph[x1][y1] - graph[x2][y2]) in l..r
}

private fun move(unions: List<List<Pair<Int, Int>>>) {
    unions.forEach { union ->
        val average = union.map { graph[it.first][it.second] }.average().toInt()
        union.forEach {
            val x = it.first
            val y = it.second
            graph[x][y] = average
        }
    }
}
