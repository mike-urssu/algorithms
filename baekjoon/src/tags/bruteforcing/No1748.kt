package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1748
 */
import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    println(getLength(n))
}

private fun getLength(n: Int): Long {
    val l = n.toString().length
    var length = (0 until l - 1).sumOf { i -> 9 * 10.0.pow(i).toLong() * (i + 1) }
    length += (n - (10.0.pow(l - 1).toLong() - 1)) * l
    return length
}
