package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/2167
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val prefixSum = getPrefixSum(n, m, array)

    val k = readln().toInt()
    repeat(k) {
        val (i, j, x, y) = readln().split(" ").map { it.toInt() }
        println("${prefixSum[x][y] - prefixSum[x][j - 1] - prefixSum[i - 1][y] + prefixSum[i - 1][j - 1]}")
    }
}

private fun getPrefixSum(n: Int, m: Int, array: Array<IntArray>): Array<IntArray> {
    val prefixSum = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n) {
        for (j in 1..m) {
            prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + array[i - 1][j - 1]
        }
    }
    return prefixSum
}
