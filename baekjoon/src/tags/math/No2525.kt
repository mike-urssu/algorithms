package tags.math

/**
 * https://www.acmicpc.net/problem/2525
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val c = readln().toInt()
    println("${(a + (b + c) / 60) % 24} ${(b + c) % 60}")
}
