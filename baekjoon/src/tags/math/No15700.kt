package tags.math

/**
 * https://www.acmicpc.net/problem/15700
 */
fun main() {
    val (n,m) = readln().split(" ").map { it.toLong() }
    println(n * m / 2)
}
