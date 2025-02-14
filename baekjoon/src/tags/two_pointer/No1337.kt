package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/1337
 */
fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { readln().toInt() }.sortedArray()

    var max = 1
    var left = 0
    var right = 1
    while (right < n) {
        if (numbers[right] - numbers[left] < 5) {
            max = max.coerceAtLeast(right - left + 1)
            right++
        } else {
            left++
        }
    }
    println((5 - max).coerceAtLeast(0))
}
