package tags.implementation

/**
 * https://www.acmicpc.net/problem/17144
 */
private var r = 0
private var c = 0
private var t = 0
private lateinit var graph: Array<IntArray>
private lateinit var airCleaner: IntArray

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    t = input[2]
    graph = Array(r) { readln().split(" ").map { it.toInt() }.toIntArray() }
    airCleaner = getAirCleaner()

    repeat(t) {
        spread()
        runAirCleaner()
    }

    println(graph.sumOf { row -> row.sumOf { it } } + 2)
}

private fun getAirCleaner(): IntArray {
    val index = (0 until r - 1).indexOfFirst { i -> graph[i][0] == -1 }
    return intArrayOf(index, index + 1)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun spread() {
    val changes = getChanges()
    (0 until r).forEach { i ->
        (0 until c).forEach { j ->
            graph[i][j] += changes[i][j]
        }
    }
}

private fun getChanges(): Array<IntArray> {
    val changes = Array(r) { IntArray(c) }
    (0 until r).forEach { i ->
        (0 until c).forEach { j ->
            val v = graph[i][j] / 5
            for (k in 0 until 4) {
                val nextX = i + dx[k]
                val nextY = j + dy[k]
                if (isInBoundary(nextX, nextY)) {
                    changes[nextX][nextY] += v
                    changes[i][j] -= v
                }
            }
        }
    }
    return changes
}

private fun isInBoundary(x: Int, y: Int): Boolean {
    val isInBoundary = x in 0 until r && y in 0 until c
    val isAirCleaner = x in airCleaner && y == 0
    return isInBoundary && !isAirCleaner
}

private fun runAirCleaner() {
    rotateCounterClockWise()
    rotateClockWise()
}

private fun rotateCounterClockWise() {
    val r1 = airCleaner[0]
    (r1 downTo 1).forEach { i -> graph[i][0] = graph[i - 1][0] }
    graph[r1][0] = 0
    (0 until c - 1).forEach { j -> graph[0][j] = graph[0][j + 1] }
    (0 until r1).forEach { i -> graph[i][c - 1] = graph[i + 1][c - 1] }
    (c - 1 downTo 1).forEach { j -> graph[r1][j] = graph[r1][j - 1] }
    graph[r1][0] = -1
}

private fun rotateClockWise() {
    val r2 = airCleaner[1]
    (r2 until r - 1).forEach { i -> graph[i][0] = graph[i + 1][0] }
    graph[r2][0] = 0
    (0 until c - 1).forEach { j -> graph[r - 1][j] = graph[r - 1][j + 1] }
    (r - 1 downTo r2 + 1).forEach { i -> graph[i][c - 1] = graph[i - 1][c - 1] }
    (c - 1 downTo 1).forEach { j -> graph[r2][j] = graph[r2][j - 1] }
    graph[r2][0] = -1
}
