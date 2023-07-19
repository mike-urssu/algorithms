package tags.sorting

/**
 * https://www.acmicpc.net/problem/1059
 */
fun main() {
    readln()
    val s = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val n = readln().toInt()

    val count = if (n in s) {
        0
    } else {
        val (from, to) = getBoundary(s, n)
        (n - from + 1) * (to - n + 1) - 1
    }
    println(count)
}

private fun getBoundary(s: IntArray, n: Int) =
    if (n < s[0]) {
        intArrayOf(1, s[0] - 1)
    } else {
        val index = -s.binarySearch(n) - 2
        intArrayOf(s[index] + 1, s[index + 1] - 1)
    }
