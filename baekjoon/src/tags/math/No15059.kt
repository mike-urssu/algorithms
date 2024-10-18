package tags.math

/**
 * https://www.acmicpc.net/problem/15059
 */
fun main() {
    val (ca, ba, pa) = readln().split(" ").map { it.toInt() }
    val (cr, br, pr) = readln().split(" ").map { it.toInt() }
    val sum = maxOf(0, cr - ca) + maxOf(0, br - ba) + maxOf(0, pr - pa)
    println(sum)
}
