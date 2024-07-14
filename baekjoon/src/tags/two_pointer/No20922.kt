package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/20922
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val counts = IntArray(100001).apply { this[numbers[0]]++ }

    var maxLength = 1
    var length = 1
    var left = 0
    var right = 1
    while (right < n) {
        if (counts[numbers[right]] < k) {
            counts[numbers[right]]++
            length++
            maxLength = maxLength.coerceAtLeast(length)
            right++
        } else {
            while (counts[numbers[right]] >= k) {
                counts[numbers[left]]--
                left++
                length--
            }
            counts[numbers[right]]++
            length++
            maxLength = maxLength.coerceAtLeast(length)
            right++
        }
    }

    println(maxLength)
}
