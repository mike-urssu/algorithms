package tags.recursion

/**
 * https://www.acmicpc.net/problem/17829
 */
private lateinit var graph: Array<IntArray>

fun main() {
    var n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    while (n != 1) {
        graph = pooling(n)
        n /= 2
    }
    println(graph[0][0])
}

private fun pooling(n: Int): Array<IntArray> {
    val newGraph = Array(n / 2) { IntArray(n / 2) }
    for (i in 0 until n / 2) {
        for (j in 0 until n / 2) {
            newGraph[i][j] = find(i, j)
        }
    }
    return newGraph
}

private fun find(i: Int, j: Int): Int {
    val values = intArrayOf(graph[i * 2][j * 2], graph[i * 2 + 1][j * 2], graph[i * 2][j * 2 + 1], graph[i * 2 + 1][j * 2 + 1])
    return values.sortedDescending()[1]
}
