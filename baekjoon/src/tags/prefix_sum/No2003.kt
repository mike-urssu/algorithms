package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/2003
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    val prefixSum = numbers.runningFold(0, Int::plus)
    var count = 0
    var left = 0
    var right = 0
    while (left <= n && right <= n) {
        if (left > right) {
            right++
            continue
        }

        val gap = prefixSum[right] - prefixSum[left]
        if (gap > m) {
            left++
        } else if (gap == m) {
            left++
            count++
        } else {
            right++
        }
    }
    println(count)
}
