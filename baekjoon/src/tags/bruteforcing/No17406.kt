package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17406
 */
private lateinit var graph: Array<IntArray>
private lateinit var clonedGraph: Array<IntArray>
private lateinit var rotations: Array<List<Int>>

private lateinit var orders: IntArray
private lateinit var isVisited: BooleanArray

private var min = Int.MAX_VALUE

fun main() {
    val (n, _, k) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    rotations = Array(k) {
        val (r, c, s) = readln().split(" ").map { it.toInt() }
        listOf(r - 1, c - 1, s)
    }

    orders = IntArray(k)
    isVisited = BooleanArray(k)

    setMin(k, 0)

    println(min)
}

private fun setMin(k: Int, index: Int) {
    if (index == k) {
        clonedGraph = Array(graph.size) { i -> graph[i].copyOf() }

        orders.forEach { i ->
            val (r, c, s) = rotations[i]
            rotate(clonedGraph, r, c, s)
        }
        min = min.coerceAtMost(clonedGraph.minOf { it.sum() })
        return
    }

    for (i in 0 until k) {
        if (!isVisited[i]) {
            isVisited[i] = true
            orders[index] = i
            setMin(k, index + 1)
            isVisited[i] = false
        }
    }
}

private fun rotate(graph: Array<IntArray>, r: Int, c: Int, s: Int) {
    for (k in 1..s) {
        val rightTop = graph[r - k][c + k]
        val rightBottom = graph[r + k][c + k]
        val leftBottom = graph[r + k][c - k]

        for (j in c + k downTo c - k + 1) {
            graph[r - k][j] = graph[r - k][j - 1]
        }

        for (i in r + k downTo r - k + 1) {
            graph[i][c + k] = graph[i - 1][c + k]
        }
        graph[r - k + 1][c + k] = rightTop

        for (j in c - k until c + k) {
            graph[r + k][j] = graph[r + k][j + 1]
        }
        graph[r + k][c + k - 1] = rightBottom

        for (i in r - k until r + k) {
            graph[i][c - k] = graph[i + 1][c - k]
        }
        graph[r + k - 1][c - k] = leftBottom
    }
}
