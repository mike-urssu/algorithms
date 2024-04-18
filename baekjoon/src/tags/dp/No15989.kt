package tags.dp

/**
 * https://www.acmicpc.net/problem/15989
 */
fun main() {
    val counts = getCounts()
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(counts[n].sum())
    }
}

private fun getCounts(): Array<IntArray> {
    val counts = Array(10001) { IntArray(3) }
    counts[0][0] = 1
    counts[1][0] = 1
    counts[2] = intArrayOf(1, 1, 0)
    (3..10000).forEach { i ->
        counts[i][0] = counts[i - 1][0]
        counts[i][1] = counts[i - 2][0] + counts[i - 2][1]
        counts[i][2] = counts[i - 3][0] + counts[i - 3][1] + counts[i - 3][2]
    }
    return counts
}
