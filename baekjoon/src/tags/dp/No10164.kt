package tags.dp

/**
 * https://www.acmicpc.net/problem/10164
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { IntArray(m) }
    if (k != 0) {
        val (x, y) = getCoordinates(m, k)
        setGraph(n, m, x, y)
    } else {
        setGraph(n, m)
    }
    println(graph[n - 1][m - 1])
}

private fun getCoordinates(m: Int, k: Int): Pair<Int, Int> {
    val x = (k - 1) / m
    val y = k % m
    return if (y == 0) {
        x to m - 1
    } else {
        x to y - 1
    }
}

private fun setGraph(n: Int, m: Int, x: Int, y: Int) {
    (0..x).forEach { i ->
        (0..y).forEach { j ->
            graph[i][j] = if (i == 0 || j == 0) {
                1
            } else {
                graph[i - 1][j] + graph[i][j - 1]
            }
        }
    }

    (x until n).forEach { i ->
        (y until m).forEach { j ->
            graph[i][j] = if (i == x || j == y) {
                graph[x][y]
            } else {
                graph[i - 1][j] + graph[i][j - 1]
            }
        }
    }
}

private fun setGraph(n: Int, m: Int) {
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            graph[i][j] = if (i == 0 || j == 0) {
                1
            } else {
                graph[i - 1][j] + graph[i][j - 1]
            }
        }
    }
}
