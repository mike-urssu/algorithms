package tags.dp

/**
 * https://www.acmicpc.net/problem/2169
 */
private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>
private lateinit var prefixSum: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val prefixSum = getPrefixSum()
    println(prefixSum.last().last())
}

private fun getPrefixSum(): Array<IntArray> {
    prefixSum = Array(n) { IntArray(m) }.apply {
        this[0][0] = graph[0][0]
        (1 until m).forEach { j -> this[0][j] = this[0][j - 1] + graph[0][j] }
    }
    (1 until n).forEach { i ->
        val rightArrowedPrefixSum = getRightArrowedPrefixSum(i)
        val leftArrowedPrefixSum = getLeftArrowedPrefixSum(i)
        (0 until m).forEach { j -> prefixSum[i][j] = maxOf(rightArrowedPrefixSum[j], leftArrowedPrefixSum[j]) }
    }
    return prefixSum
}

private fun getRightArrowedPrefixSum(x: Int): IntArray {
    val sum = IntArray(m)
    sum[0] = prefixSum[x - 1][0] + graph[x][0]
    (1 until m).forEach { j ->
        sum[j] = (sum[j - 1] + graph[x][j]).coerceAtLeast(prefixSum[x - 1][j] + graph[x][j])
    }
    return sum
}

private fun getLeftArrowedPrefixSum(x: Int): IntArray {
    val sum = IntArray(m)
    sum[m - 1] = prefixSum[x - 1][m - 1] + graph[x][m - 1]
    (m - 2 downTo 0).forEach { j ->
        sum[j] = (sum[j + 1] + graph[x][j]).coerceAtLeast(prefixSum[x - 1][j] + graph[x][j])
    }
    return sum
}
