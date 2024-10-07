package tags.math

/**
 * https://www.acmicpc.net/problem/26307
 */
fun main() {
    val (hh, mm) = readln().split(" ").map { it.toInt() }
    println((hh - 9) * 60 + mm)
}
