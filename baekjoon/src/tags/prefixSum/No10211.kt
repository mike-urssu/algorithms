package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/10211
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val array = readln().split(" ").map { it.toInt() }.toIntArray()
        val prefixSum = getPrefixSum(n, array)
        var max = Int.MIN_VALUE
        for (i in 1..n) {
            for (j in 0 until i) {
                max = max.coerceAtLeast(prefixSum[i] - prefixSum[j])
            }
        }
        println(max)
    }
}

private fun getPrefixSum(n: Int, array: IntArray): IntArray {
    val prefixSum = IntArray(n + 1)
    (1..n).forEach { i -> prefixSum[i] = prefixSum[i - 1] + array[i - 1] }
    return prefixSum
}
