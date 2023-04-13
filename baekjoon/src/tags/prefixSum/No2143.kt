package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/2143
 */
fun main() {
    val t = readln().toInt()
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }

    val prefixSumA = getPrefixSum(n, a)
    val prefixSumB = getPrefixSum(m, b)

    val groupA = getGroup(prefixSumA)
    val groupB = getGroup(prefixSumB)

    val count = groupA.keys.sumOf { key -> groupA[key]!! * (groupB[t - key] ?: 0) }
    println(count)
}

private fun getPrefixSum(n: Int, numbers: List<Int>): LongArray {
    val prefixSum = LongArray(n + 1)
    (1..n).forEach { i -> prefixSum[i] = prefixSum[i - 1] + numbers[i - 1] }
    return prefixSum
}

private fun getGroup(prefixSum: LongArray): Map<Long, Long> {
    val group = sortedMapOf<Long, Long>()
    for (i in prefixSum.indices) {
        for (j in i + 1 until prefixSum.size) {
            val n = prefixSum[j] - prefixSum[i]
            group[n] = (group[n] ?: 0) + 1
        }
    }
    return group
}
