package tags.bfs

/**
 * https://www.acmicpc.net/problem/16933
 */
private var n = 0
private var m = 0
private var k = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<Array<BooleanArray>>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    k = input[2]
    graph = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    isVisited = Array(k + 1) { Array(n) { BooleanArray(m) } }

    println(getDistance())
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun getDistance(): Int {
    isVisited[0][0][0] = true
    val queue = ArrayDeque<IntArray>()
    queue.add(intArrayOf(0, 0, 1, 0, 0))

    while (queue.isNotEmpty()) {
        val (x, y, c, w, t) = queue.removeFirst()
        if (x == n - 1 && y == m - 1) {
            return c
        }

        (0 until 4).forEach { i ->
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY)) {
                if (graph[nextX][nextY] == 0) {
                    if (!isVisited[w][nextX][nextY]) {
                        isVisited[w][nextX][nextY] = true
                        queue.add(intArrayOf(nextX, nextY, c + 1, w, t + 1))
                    }
                } else {
                    if (w + 1 <= k) {
                        if (t % 2 == 0) {
                            if (!isVisited[w + 1][nextX][nextY]) {
                                isVisited[w + 1][nextX][nextY] = true
                                queue.add(intArrayOf(nextX, nextY, c + 1, w + 1, t + 1))
                            }
                        } else {
                            queue.add(intArrayOf(x, y, c + 1, w, t + 1))
                        }
                    }
                }
            }
        }
    }
    return -1
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
