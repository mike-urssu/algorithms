package tags.math

/**
 * https://www.acmicpc.net/problem/27959
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    if (n * 100 >= m) {
        println("Yes")
    } else {
        println("No")
    }
}
