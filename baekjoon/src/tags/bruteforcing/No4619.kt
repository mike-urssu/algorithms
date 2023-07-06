package tags.bruteforcing

import kotlin.math.abs
import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/4619
 */
fun main() {
    while (true) {
        val (b, n) = readln().split(" ").map { it.toInt() }
        if (b == 0 && n == 0) {
            break
        }

        var a = 1
        var diff = Int.MAX_VALUE
        while (true) {
            val pow = a.toDouble().pow(n).toInt()
            if (diff < abs(b - pow)) {
                break
            }
            diff = abs(b - pow)
            a++
        }
        println(a - 1)
    }
}
