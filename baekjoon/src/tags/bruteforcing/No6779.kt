package tags.bruteforcing

import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/6779
 */
fun main() {
    val h = readln().toInt()
    val m = readln().toInt()

    for (t in 1..m) {
        if (getAltitude(h, t) <= 0) {
            println("The balloon first touches ground at hour: $t")
            return
        }
    }
    println("The balloon does not touch ground in the given time.")
}

private fun getAltitude(h: Int, t: Int): Int {
    return -6 * pow(t, 4) + h * pow(t, 3) + 2 * pow(t, 2) + t
}

private fun pow(t: Int, n: Int): Int {
    return t.toDouble().pow(n).toInt()
}
