package tags.bfs

/**
 * https://www.acmicpc.net/problem/3187
 */
import java.util.LinkedList
import java.util.Queue

private var r = 0
private var c = 0
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>

private var sheep = 0
private var wolf = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    graph = Array(r) { readln().toCharArray() }
    isVisited = Array(r) { BooleanArray(c) }

    (0 until r).forEach { i ->
        (0 until c).forEach { j ->
            if (!isVisited[i][j] && graph[i][j] != '#') {
                isVisited[i][j] = true
                bfs(i, j)
            }
        }
    }
    println("$sheep $wolf")
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun bfs(srcX: Int, srcY: Int) {
    var s = 0
    var w = 0
    if (graph[srcX][srcY] == 'k') {
        s++
    } else if (graph[srcX][srcY] == 'v') {
        w++
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(srcX to srcY)
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (graph[nextX][nextY] != '#') {
                    if (graph[nextX][nextY] == 'k') {
                        s++
                    } else if (graph[nextX][nextY] == 'v') {
                        w++
                    }
                    queue.add(nextX to nextY)
                }
                isVisited[nextX][nextY] = true
            }
        }
    }

    if (s > w) {
        sheep += s
    } else {
        wolf += w
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until r && y in 0 until c
