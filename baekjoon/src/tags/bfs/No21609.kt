package tags.bfs

/**
 * https://www.acmicpc.net/problem/21609
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    var score = 0
    while (true) {
        isVisited = Array(n) { BooleanArray(n) }
        val (x, y, size) = findGroup()
        if (size < 2) {
            break
        }
        score += size * size
        remove(x, y)
        gravity()
        rotate()
        gravity()
    }
    println(score)
}

private fun findGroup(): Triple<Int, Int, Int> {
    var x = 0
    var y = 0
    var maxColorSize = 0
    var maxZeroSize = 0

    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (!isVisited[i][j] && graph[i][j] in 1..m) {
                val (minX, minY, colorSize, zeroSize) = find(i, j)
                if (maxColorSize + maxZeroSize < colorSize + zeroSize) {
                    maxColorSize = colorSize
                    maxZeroSize = zeroSize
                    x = minX
                    y = minY
                } else if (maxColorSize + maxZeroSize == colorSize + zeroSize) {
                    if (maxZeroSize < zeroSize) {
                        maxColorSize = colorSize
                        maxZeroSize = zeroSize
                        x = minX
                        y = minY
                    } else if (maxZeroSize == zeroSize) {
                        if (x < i) {
                            maxColorSize = colorSize
                            maxZeroSize = zeroSize
                            x = minX
                            y = minY
                        } else if (x == i) {
                            if (y < j) {
                                maxColorSize = colorSize
                                maxZeroSize = zeroSize
                                x = minX
                                y = minY
                            }
                        }
                    }
                }
            }
        }
    }
    return Triple(x, y, maxColorSize + maxZeroSize)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun find(i: Int, j: Int): IntArray {
    val color = graph[i][j]
    var minX = i
    var minY = j
    val zeroCords = mutableListOf<Pair<Int, Int>>()
    var countColor = 1
    var countZero = 0

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(i to j)
    isVisited[i][j] = true

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (graph[nextX][nextY] == color) {
                    queue.add(nextX to nextY)
                    isVisited[nextX][nextY] = true
                    countColor++

                    if (minX > nextX) {
                        minX = nextX
                        minY = nextY
                    } else if (minX == nextX && minY > nextY) {
                        minX = nextX
                        minY = nextY
                    }
                } else if (graph[nextX][nextY] == 0) {
                    queue.add(nextX to nextY)
                    isVisited[nextX][nextY] = true
                    countZero++
                    zeroCords.add(nextX to nextY)
                }
            }
        }
    }

    zeroCords.forEach { (zeroX, zeroY) ->
        isVisited[zeroX][zeroY] = false
    }
    return intArrayOf(minX, minY, countColor, countZero)
}

private fun remove(i: Int, j: Int) {
    val color = graph[i][j]

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val isVisited = Array(n) { BooleanArray(n) }
    queue.add(i to j)
    isVisited[i][j] = true
    graph[i][j] = -99

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (graph[nextX][nextY] == color || graph[nextX][nextY] == 0) {
                    queue.add(nextX to nextY)
                    isVisited[nextX][nextY] = true
                    graph[nextX][nextY] = -99
                }
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n

private fun gravity() {
    (0 until n).forEach { j ->
        (n - 2 downTo 0).forEach { i ->
            if (graph[i][j] != -1 && graph[i][j] != -99) {
                var x = i
                while (x + 1 < n && graph[x + 1][j] == -99) {
                    graph[x + 1][j] = graph[x][j]
                    graph[x][j] = -99
                    x++
                }
            }
        }
    }
}

private fun rotate() {
    for (k in 0 until n / 2) {
        val copy = graph[k].copyOfRange(k, n - k)

        for (j in k until n - 1 - k) {
            graph[k][j] = graph[j][n - 1 - k]
        }

        for (i in k until n - 1 - k) {
            graph[i][n - 1 - k] = graph[n - 1 - k][n - 1 - i]
        }

        for (j in n - 1 - k downTo 1 + k) {
            graph[n - 1 - k][j] = graph[j][k]
        }

        (0 until n - k * 2).forEach { i ->
            graph[n - 1 - k - i][k] = copy[i]
        }
    }
}
