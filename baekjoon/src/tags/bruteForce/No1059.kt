package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1059
 */
fun main() {
    readln().toInt()
    val s = readln().split(" ").map { it.toInt() }.sorted()
    val n = readln().toInt()

    var count = 0
    if (!s.contains(n)) {
        val (from, to) = getBoundary(s, n)
        count = (n - from + 1) * (to - n + 1) - 1
    }
    println(count)
}

private fun getBoundary(s: List<Int>, n: Int): IntArray {
    return if (n < s.first()) {
        intArrayOf(1, s.first() - 1)
    } else {
        val index = -s.binarySearch(n) - 2
        intArrayOf(s[index] + 1, s[index + 1] - 1)
    }
}
