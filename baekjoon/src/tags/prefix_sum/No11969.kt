package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/11969
 */
fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val breedIds = IntArray(n) { readln().toInt() }

    val prefixSum = getPrefixSum(n, breedIds)
    repeat(q) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val numberOfCows = (0..2).joinToString(" ") { i -> "${prefixSum[i][b] - prefixSum[i][a - 1]}" }
        println(numberOfCows)
    }
}

private fun getPrefixSum(n: Int, breedIds: IntArray): Array<IntArray> {
    val prefixSum = Array(3) { IntArray(n + 1) }
    breedIds.forEachIndexed { i, breedId ->
        (0..2).forEach { prefixSum[it][i + 1] = prefixSum[it][i] }
        when (breedId) {
            1 -> prefixSum[0][i + 1] = prefixSum[0][i] + 1
            2 -> prefixSum[1][i + 1] = prefixSum[1][i] + 1
            3 -> prefixSum[2][i + 1] = prefixSum[2][i] + 1
        }
    }
    return prefixSum
}
