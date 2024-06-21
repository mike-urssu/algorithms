package tags.math

/**
 * https://www.acmicpc.net/problem/29751
 */
fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    println(String.format("%.1f", (w * h) / 2.0))
}
