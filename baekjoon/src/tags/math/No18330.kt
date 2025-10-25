package tags.math

/**
 * https://www.acmicpc.net/problem/18330
 */
fun main() {
    val n = readln().toInt()
    val k = readln().toInt()

    val cost = if (n <= 60 + k) {
        n * 1500
    } else {
        (k + 60) * 1500 + (n - k - 60) * 3000
    }
    println(cost)
}
