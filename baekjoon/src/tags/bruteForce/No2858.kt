package tags.bruteForce

import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/2858
 */
fun main() {
    val (r, b) = readln().split(" ").map { it.toInt() }
    val sum = r + b

    for (w in 1..sqrt(sum.toDouble()).toInt()) {
        val l = sum / w
        if (r == w * l - b && b == (w - 2) * (l - 2)) {
            println("$l $w")
            return
        }
    }
}
