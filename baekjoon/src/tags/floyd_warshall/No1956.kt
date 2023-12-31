package tags.floyd_warshall

/**
 * https://www.acmicpc.net/problem/1956
 */
private lateinit var distances: Array<IntArray>
private const val MAX = 1_000_000_000

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    distances = getDistances(v, e)
    setShortestPaths(v)
    println(getMin(v))
}

private fun getDistances(v: Int, e: Int): Array<IntArray> {
    val distances = Array(v + 1) { IntArray(v + 1) { MAX } }
    (1..v).forEach { i -> distances[i][i] = 0 }
    repeat(e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        distances[a][b] = c
    }
    return distances
}

private fun setShortestPaths(v: Int) {
    for (src in 1..v) {
        for (dst in 1..v) {
            for (k in 1..v) {
                if (distances[src][dst] > distances[src][k] + distances[k][dst]) {
                    distances[src][dst] = distances[src][k] + distances[k][dst]
                }
            }
        }
    }
}

private fun getMin(v: Int): Int {
    var min = MAX

    for (i in 1..v) {
        for (j in 1..v) {
            if (i != j && distances[i][j] != MAX && distances[j][i] != MAX) {
                min = min.coerceAtMost(distances[i][j] + distances[j][i])
            }
        }
    }

    if (min == MAX) {
        min = -1
    }
    return min
}
