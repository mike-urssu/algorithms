package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/2230
 */
private var min = Int.MAX_VALUE

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = IntArray(n) { readln().toInt() }.sortedArray()

    var left = 0
    var right = 0
    while (right < n) {
        if (left == right) {
            right++
        } else {
            if (numbers[right] - numbers[left] >= m) {
                min = min.coerceAtMost(numbers[right] - numbers[left])
                left++
            } else {
                right++
            }
        }
    }

    println(min)
}
