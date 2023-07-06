package tags.bruteforcing

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1977
 */
fun main() {
    val m = readln().toInt()
    val n = readln().toInt()

    val n2 = sqrt(n.toDouble()).toInt()
    if (n2.toDouble().pow(2) < m) {
        println(-1)
    } else {
        var sum = 0
        var min = 0
        var number = n2

        while (number * number >= m) {
            sum += number * number
            min = number
            number--
        }

        println(sum)
        println(min * min)
    }
}
