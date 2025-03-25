package tags.math

/**
 * https://www.acmicpc.net/problem/31450
 */
fun main() {
    val (m, k) = readln().split(" ").map { it.toInt() }
    if (m % k == 0) {
        println("Yes")
    } else {
        println("No")
    }
}
