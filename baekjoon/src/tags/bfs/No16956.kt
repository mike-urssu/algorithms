package tags.bfs

/**
 * https://www.acmicpc.net/problem/16956
 */
private var r = 0
private var c = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    graph = Array(r) { readln().toCharArray() }

    if (canBlock()) {
        block()
        println("1")
        graph.forEach { println(it.joinToString("")) }
    } else {
        println("0")
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun canBlock(): Boolean {
    val wolves = findWolves()
    wolves.forEach { (x, y) ->
        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 'S') {
                return false
            }
        }
    }
    return true
}

private fun findWolves(): List<Pair<Int, Int>> {
    val positions = mutableListOf<Pair<Int, Int>>()
    (0 until r).forEach { x ->
        (0 until c).forEach { y ->
            if (graph[x][y] == 'W') {
                positions.add(x to y)
            }
        }
    }
    return positions
}

private fun block() {
    (0 until r).forEach { x ->
        (0 until c).forEach { y ->
            if (graph[x][y] == 'S') {
                (0 until 4).forEach { k ->
                    val nextX = x + dx[k]
                    val nextY = y + dy[k]
                    if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == '.') {
                        graph[nextX][nextY] = 'D'
                    }
                }
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until r && y in 0 until c
