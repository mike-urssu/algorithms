package tags.math

/**
 * https://www.acmicpc.net/problem/14913
 */
fun main() {
    val (a, d, k) = readln().split(" ").map { it.toInt() }
    if ((k - a) % d != 0 || (k - a) / d == -1) {
        println('X')
        return
    }
    println((k - a) / d + 1)
}
