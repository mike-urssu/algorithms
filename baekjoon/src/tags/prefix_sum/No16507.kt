package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/16507
 */
fun main() {
    val (r, c, q) = readln().split(" ").map { it.toInt() }
    val array = Array(r) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val prefixSum = Array(r + 1) { IntArray(c + 1) }
    (1..r).forEach { i ->
        (1..c).forEach { j ->
            prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] + array[i - 1][j - 1] - prefixSum[i - 1][j - 1]
        }
    }

    repeat(q) {
        val (r1, c1, r2, c2) = readln().split(" ").map { it.toInt() }
        println("${(prefixSum[r2][c2] - prefixSum[r1 - 1][c2] - prefixSum[r2][c1 - 1] + prefixSum[r1 - 1][c1 - 1]) / ((r2 - r1 + 1) * (c2 - c1 + 1))}")
    }
}
