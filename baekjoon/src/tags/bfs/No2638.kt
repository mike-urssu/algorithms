package tags.bfs

/**
 * https://www.acmicpc.net/problem/2638
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

    println(getTime())
}

private fun getTime(): Int {
    var time = 0
    while (true) {
        if (graph.all { row -> row.all { it == 0 } }) {
            break
        }

        melt()
        time++
    }
    return time
}

private fun melt() {
    val touches = getTouches()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1 && touches[i][j] >= 2) {
                graph[i][j]--
            }
        }
    }
}


private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getTouches(): Array<IntArray> {
    val touches = Array(n) { IntArray(m) }
    val airs = getAirs()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1) {
                for (k in 0 until 4) {
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY) && airs[nextX][nextY]) {
                        touches[i][j]++
                    }
                }
            }
        }
    }

    return touches
}

private fun getAirs(): Array<BooleanArray> {
    val airs = Array(n) { BooleanArray(m) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(0, 0))
    airs[0][0] = true

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

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
