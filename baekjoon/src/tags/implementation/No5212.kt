package tags.implementation

/**
 * https://www.acmicpc.net/problem/5212
 */
private var r = 0
private var c = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    graph = Array(r) { readln().toCharArray() }

    sink()
    drawMap()
}

private fun sink() {
    val isSinking = Array(r) { BooleanArray(c) }
    (0 until r).forEach { i ->
        (0 until c).forEach { j ->
            if (graph[i][j] == 'X' && isSinking(i, j)) {
                isSinking[i][j] = true
            }
        }
    }

    (0 until r).forEach { i ->
        (0 until c).forEach { j ->
            if (isSinking[i][j]) {
                graph[i][j] = '.'
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun isSinking(x: Int, y: Int): Boolean {
    val count = (0 until 4).count { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        !isInBoundary(nextX, nextY) || graph[nextX][nextY] == '.'
    }
    return count >= 3
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until r && y in 0 until c

private fun drawMap() {
    val x1 = (0 until r).first { graph[it].contains('X') }
    val y1 = (0 until c).first { j -> (0 until r).any { i -> graph[i][j] == 'X' } }
    val x2 = (r - 1 downTo 0).first { graph[it].contains('X') }
    val y2 = (c - 1 downTo 0).first { j -> (r - 1 downTo 0).any { i -> graph[i][j] == 'X' } }

    (x1..x2).forEach { i ->
        (y1..y2).forEach { j ->
            print(graph[i][j])
        }
        println()
    }
}
