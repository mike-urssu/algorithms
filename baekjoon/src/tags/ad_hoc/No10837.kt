package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/10837
 */
fun main() {
    val k = readln().toInt()
    val c = readln().toInt()
    repeat(c) {
        val (m, n) = readln().split(" ").map { it.toInt() }
        val isValid = if (m == n) {
            true
        } else if (m < n) {
            m + k - 2 * (n - 1) > 0
        } else {
            k + n - 2 * (m - 1) + 1 > 0
        }
        if (isValid) {
            println(1)
        } else {
            println(0)
        }
    }
}
