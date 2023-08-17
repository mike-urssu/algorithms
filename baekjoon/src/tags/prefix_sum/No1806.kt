package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/1806
 */
fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }

    var left = 0
    var right = 0
    var min = Int.MAX_VALUE

    var sum = numbers[0]
    while (true) {
        if (sum < s) {
            right++
            if (right == n) {
                break
            } else {
                sum += numbers[right]
            }
        } else {
            min = min.coerceAtMost(right - left + 1)
            sum -= numbers[left++]
        }
    }

    if (min == Int.MAX_VALUE) {
        min = 0
    }
    println(min)
}
