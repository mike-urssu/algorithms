package tags.implementation

/**
 * https://www.acmicpc.net/problem/1913
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val n = readln().toInt()
    val num = readln().toInt()

    graph = getGraph(n)
    val (row, col) = getCoordinates(n, num)

    graph.forEach { println(it.joinToString(" ")) }
    println("$row $col")
}

private fun getGraph(n: Int): Array<IntArray> {
    val graph = Array(n) { IntArray(n) }
    var num = 1
    graph[n / 2][n / 2] = num++
    val s = n / 2
    for (k in 0 until s) {
        ((s - k) until (s - k) + (k + 1) * 2).forEach { j -> graph[s - (k + 1)][j] = num++ }
        ((s - k) until (s - k) + (k + 1) * 2).forEach { i -> graph[i][s + (k + 1)] = num++ }
        ((s + k) downTo (s + k + 1 - 2 * (k + 1))).forEach { j -> graph[s + (k + 1)][j] = num++ }
        ((s + k) downTo (s + k) + 1 - 2 * (k + 1)).forEach { i -> graph[i][s - (k + 1)] = num++ }
    }
    return graph
}

private fun getCoordinates(n: Int, num: Int): Pair<Int, Int> {
    var row = 0
    var col = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == num) {
                row = i
                col = j
            }
        }
    }
    return row + 1 to col + 1
}
