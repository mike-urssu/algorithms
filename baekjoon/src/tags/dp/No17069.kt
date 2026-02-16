package tags.dp

/**
 * https://www.acmicpc.net/problem/17069
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var counts: Array<Array<LongArray>>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    counts = Array(n) { Array(n) { LongArray(n) } }.apply {
        this[0][0][1] = 1
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 1) {
                continue
            }

            if (isInBoundary(i, j - 1)) {
                counts[0][i][j] += counts[0][i][j - 1] + counts[1][i][j - 1]
            }

            if (
                isInBoundary(i - 1, j - 1)
                && isInBoundary(i - 1, j)
                && isInBoundary(i, j - 1)
            ) {
                counts[1][i][j] += counts[0][i - 1][j - 1] + counts[1][i - 1][j - 1] + counts[2][i - 1][j - 1]
            }

            if (isInBoundary(i - 1, j)) {
                counts[2][i][j] += counts[1][i - 1][j] + counts[2][i - 1][j]
            }
        }
    }
    println((0 until 3).sumOf { counts[it][n - 1][n - 1] })
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0..n && y in 0..n && graph[x][y] == 0
