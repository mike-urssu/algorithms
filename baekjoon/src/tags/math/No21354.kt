package tags.math

/**
 * https://www.acmicpc.net/problem/21354
 */
fun main() {
    val (a, p) = readln().split(" ").map { it.toInt() }
    val applePrice = a * 7
    val pearPrice = p * 13
    val winner = when {
        applePrice > pearPrice -> "Axel"
        applePrice < pearPrice -> "Petra"
        else -> "lika"
    }
    println(winner)
}
