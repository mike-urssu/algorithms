package tags.math

/**
 * https://www.acmicpc.net/problem/21591
 */
fun main() {
    val (wc, hc, ws, hs) = readln().split(" ").map { it.toInt() }
    val isFit = if (wc >= ws + 2 && hc >= hs + 2) {
        1
    } else {
        0
    }
    println(isFit)
}
