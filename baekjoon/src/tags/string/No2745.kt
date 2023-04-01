package tags.string

import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/2745
 */
fun main() {
    val (n, b) = readln().split(" ")
    var sum = 0
    n.reversed().forEachIndexed { index, c ->
        sum += if (c.isDigit()) {
            c.digitToInt()
        } else {
            (c - 'A' + 10)
        } * b.toDouble().pow(index).toInt()
    }
    println(sum)
}
