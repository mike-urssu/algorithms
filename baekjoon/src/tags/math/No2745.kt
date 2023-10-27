package tags.math

/**
 * https://www.acmicpc.net/problem/2745
 */
import kotlin.math.pow

fun main() {
    val input = readln().split(" ")
    val n = input[0]
    val b = input[1].toDouble()

    val decimal = n.reversed().mapIndexed { i, c ->
        if (c in '0'..'9') {
            c.digitToInt() * b.pow(i)
        } else {
            (c - 'A' + 10) * b.pow(i)
        }.toInt()
    }.sum()
    println(decimal)
}
