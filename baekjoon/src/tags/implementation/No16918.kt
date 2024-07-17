package tags.implementation

/**
 * https://www.acmicpc.net/problem/16918
 */
private var r = 0
private var c = 0
private lateinit var graph: Array<IntArray>
private var seconds = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    val n = input[2]
    graph = getGraph()

    doNothing()
    seconds++

    while (true) {
        if (seconds == n) {
            break
        }
        explode()
        seconds++
    }

    graph.forEach { row ->
        println(row.map { if (it == -1) '.' else 'O' }.joinToString(""))
    }
}

private fun getGraph(): Array<IntArray> {
    return Array(r) {
        readln().toCharArray().map {
            if (it == '.') {
                -1
            } else {
                0
            }
        }.toIntArray()
    }
}

private fun doNothing() {
    (0 until r).forEach { x ->
        (0 until c).forEach { y ->
            if (graph[x][y] != -1) {
                graph[x][y]++
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun explode() {
    inc()

    (0 until r).forEach { x ->
        (0 until c).forEach { y ->
            if (graph[x][y] == 3) {
                (0 until 4).forEach { k ->
                    val nextX = x + dx[k]
                    val nextY = y + dy[k]
                    if (isInBoundary(nextX, nextY) && graph[nextX][nextY] != 3) {
                        graph[nextX][nextY] = -1
                    }
                }
                graph[x][y] = -1
            }
        }
    }
}

private fun inc() {
    (0 until r).forEach { x ->
        (0 until c).forEach { y ->
            graph[x][y]++
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until r && y in 0 until c
