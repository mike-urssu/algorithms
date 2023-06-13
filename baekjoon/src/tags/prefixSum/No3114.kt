package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/3114
 */
private lateinit var apples: Array<IntArray>
private lateinit var bananas: Array<IntArray>
private lateinit var prefixSumOfApples: Array<IntArray>
private lateinit var prefixSumOfBananas: Array<IntArray>

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    apples = Array(r) { IntArray(c) }
    bananas = Array(r) { IntArray(c) }
    repeat(r) { i ->
        val trees = readln().split(" ")
        trees.forEachIndexed { j, tree ->
            if (tree[0] == 'A') {
                apples[i][j] = tree.substring(1).toInt()
            } else {
                bananas[i][j] = tree.substring(1).toInt()
            }
        }
    }
    prefixSumOfApples = getPrefixSumOfApples(r, c)
    prefixSumOfBananas = getPrefixSumOfBananas(r, c)
    println(getDp(r, c).last().last())
}

private fun getPrefixSumOfApples(r: Int, c: Int): Array<IntArray> {
    val prefixSumOfApples = Array(r) { IntArray(c) }
    for (i in r - 2 downTo 0) {
        for (j in 0 until c) {
            prefixSumOfApples[i][j] = prefixSumOfApples[i + 1][j]
            prefixSumOfApples[i][j] += apples[i + 1][j]
        }
    }
    return prefixSumOfApples
}

private fun getPrefixSumOfBananas(r: Int, c: Int): Array<IntArray> {
    val prefixSumOfBananas = Array(r) { IntArray(c) }
    for (i in 1 until r) {
        for (j in 1 until c) {
            prefixSumOfBananas[i][j] = prefixSumOfBananas[i - 1][j]
            prefixSumOfBananas[i][j] += bananas[i - 1][j]
        }
    }
    return prefixSumOfBananas
}

private fun getDp(r: Int, c: Int): Array<IntArray> {
    val dp = Array(r) { IntArray(c) }
    dp[0] = prefixSumOfApples[0].runningFold(0, Int::plus).drop(1).toIntArray()
    for (i in 1 until r) {
        for (j in 0 until c) {
            dp[i][j] = if (j == 0) {
                prefixSumOfApples[i][j]
            } else {
                maxOf(
                    dp[i][j - 1] + prefixSumOfApples[i][j] + prefixSumOfBananas[i][j],
                    dp[i - 1][j - 1] + prefixSumOfApples[i][j] + prefixSumOfBananas[i][j],
                    dp[i - 1][j] - apples[i][j]
                )
            }
        }
    }
    return dp
}
