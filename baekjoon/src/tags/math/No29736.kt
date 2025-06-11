package tags.math

/**
 * https://www.acmicpc.net/problem/29736
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (k, x) = readln().split(" ").map { it.toInt() }
    val count = (k - x..k + x).count { it in a..b }
    if (count == 0) {
        println("IMPOSSIBLE")
    } else {
        println(count)
    }
}
