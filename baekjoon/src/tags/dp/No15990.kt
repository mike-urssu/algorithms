package tags.dp

/**
 * https://www.acmicpc.net/problem/15990
 */
fun main() {
    val counts = getCounts()
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(counts[n].sum() % 1000000009)
    }
}

private fun getCounts(): Array<LongArray> {
    val counts = Array(100001) { LongArray(4) }
    counts[1] = longArrayOf(0, 1, 0, 0)
    counts[2] = longArrayOf(0, 0, 1, 0)
    counts[3] = longArrayOf(0, 1, 1, 1)
    for (i in 4..100000) {
        counts[i][1] = (counts[i - 1][2] + counts[i - 1][3]) % 1000000009
        counts[i][2] = (counts[i - 2][1] + counts[i - 2][3]) % 1000000009
        counts[i][3] = (counts[i - 3][1] + counts[i - 3][2]) % 1000000009
    }
    return counts
}
