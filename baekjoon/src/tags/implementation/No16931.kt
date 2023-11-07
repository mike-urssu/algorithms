package tags.implementation

/**
 * https://www.acmicpc.net/problem/16931
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    println(getArea(n, m))
}

private fun getArea(n: Int, m: Int): Int {
    var area = n * m * 2

    for (i in 0 until n) {
        area += graph[i][0]
        for (j in 1 until m) {
            area += maxOf(0, graph[i][j] - graph[i][j - 1])
        }
    }

    for (i in 0 until n) {
        area += graph[i][m - 1]
        for (j in m - 2 downTo 0) {
            area += maxOf(0, graph[i][j] - graph[i][j + 1])
        }
    }

    for (j in 0 until m) {
        area += graph[0][j]
        for (i in 1 until n) {
            area += maxOf(0, graph[i][j] - graph[i - 1][j])
        }
    }

    for (j in 0 until m) {
        area += graph[n - 1][j]
        for (i in n - 2 downTo 0) {
            area += maxOf(0, graph[i][j] - graph[i + 1][j])
        }
    }

    return area
}
