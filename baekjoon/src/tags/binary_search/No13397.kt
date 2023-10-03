package tags.binary_search

/**
 * https://www.acmicpc.net/problem/13397
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getLeastMax(n, m, numbers))
}

private fun getLeastMax(n: Int, m: Int, numbers: IntArray): Int {
    var low = -1
    var high = 20001
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (isValid(n, m, numbers, mid)) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun isValid(n: Int, m: Int, numbers: IntArray, mid: Int): Boolean {
    var group = 1
    var min = numbers[0]
    var max = numbers[0]
    for (i in 1 until n) {
        max = max.coerceAtLeast(numbers[i])
        min = min.coerceAtMost(numbers[i])
        if (max - min > mid) {
            max = numbers[i]
            min = numbers[i]
            group++
        }
    }
    return group <= m
}
