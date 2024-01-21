package tags.math

/**
 * https://www.acmicpc.net/problem/2875
 */
fun main() {
    var (n, m, k) = readln().split(" ").map { it.toInt() }
    var team = 0
    while ((n >= 2 && m >= 1) && (n - 2) + (m - 1) >= k) {
        n -= 2
        m -= 1
        team++
    }
    println(team)
}
