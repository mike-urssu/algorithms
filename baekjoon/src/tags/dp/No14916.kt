package tags.dp

/**
 * https://www.acmicpc.net/problem/14916
 */
fun main() {
    val n = readln().toInt()
    println(getCounts()[n])
}

private fun getCounts(): IntArray {
    val counts = IntArray(100001)
    counts[1] = -1
    counts[2] = 1
    counts[3] = -1
    counts[4] = 2
    counts[5] = 1
    (6..100000).forEach { i ->
        counts[i] = if (i % 5 == 0) {
            counts[i - 5]
        } else {
            counts[i - 2]
        } + 1
    }
    return counts
}
