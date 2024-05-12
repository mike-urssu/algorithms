package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/22862
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    var max = 0
    var evens = 0
    var odds = 0
    var left = 0
    var right = 0
    while (right < n) {
        if (numbers[right] % 2 == 0) {
            right++
            evens++
            max = max.coerceAtLeast(evens)
        } else {
            if (odds < k) {
                right++
                odds++
            } else {
                while (left <= right) {
                    if (numbers[left] % 2 == 0) {
                        left++
                        evens--
                    } else {
                        left++
                        odds--
                        break
                    }
                }
            }
        }
    }
    println(max)
}
