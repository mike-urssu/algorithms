package tags.implementation

/**
 * https://www.acmicpc.net/problem/21610
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var clouds: MutableList<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    val m = input[1]

    graph = getGraph()
    clouds = mutableListOf<IntArray>().apply {
        this.add(intArrayOf(n - 1, 1))
        this.add(intArrayOf(n - 1, 2))
        this.add(intArrayOf(n, 1))
        this.add(intArrayOf(n, 2))
    }

    repeat(m) {
        val (d, s) = readln().split(" ").map { it.toInt() }
        moveClouds(d, s)
        inc()

        magic()
        setClouds()
    }
    println(graph.sumOf { it.sum() })
}

private fun getGraph(): Array<IntArray> {
    val graph = Array(n + 1) { IntArray(n + 1) }
    (1..n).forEach { i -> readln().split(" ").map { it.toInt() }.toIntArray().copyInto(graph[i], 1) }
    return graph
}

private val dx = intArrayOf(0, 0, -1, -1, -1, 0, 1, 1, 1)
private val dy = intArrayOf(0, -1, -1, 0, 1, 1, 1, 0, -1)

private fun moveClouds(d: Int, s: Int) {
    for (i in clouds.indices) {
        for (k in 0 until s) {
            clouds[i][0] += dx[d]
            clouds[i][1] += dy[d]

            if (clouds[i][0] == 0) {
                clouds[i][0] = n
            }
            if (clouds[i][0] == n + 1) {
                clouds[i][0] = 1
            }
            if (clouds[i][1] == 0) {
                clouds[i][1] = n
            }
            if (clouds[i][1] == n + 1) {
                clouds[i][1] = 1
            }
        }
    }
}

private fun inc() =
    clouds.forEach { (x, y) -> graph[x][y]++ }

private val ddx = intArrayOf(-1, 1, 1, -1)
private val ddy = intArrayOf(-1, -1, 1, 1)

private fun magic() {
    clouds.forEachIndexed { i, (x, y) ->
        val counts = (0 until 4).count { k ->
            val nextX = x + ddx[k]
            val nextY = y + ddy[k]
            isInBoundary(nextX, nextY) && graph[nextX][nextY] != 0
        }
        graph[x][y] += counts
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 1..n && y in 1..n

private fun setClouds() {
    val coordinates = clouds.map { (x, y) -> x to y }.toSet()

    clouds = mutableListOf()
    (1..n).forEach { i ->
        (1..n).forEach { j ->
            if (!coordinates.contains(i to j) && graph[i][j] >= 2) {
                graph[i][j] -= 2
                clouds.add(intArrayOf(i, j))
            }
        }
    }
}
