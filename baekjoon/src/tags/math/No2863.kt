package tags.math

/**
 * https://www.acmicpc.net/problem/2863
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toDouble() }
    val (c, d) = readln().split(" ").map { it.toDouble() }
    val results = doubleArrayOf(
        (a * d + b * c) / (c * d),
        (b * c + a * d) / (b * d),
        (a * d + b * c) / (a * b),
        (b * c + a * d) / (a * c)
    )
    val max = results.max()
    println(results.indexOfFirst { it == max })
}
