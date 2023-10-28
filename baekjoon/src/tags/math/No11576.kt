package tags.math

/**
 * https://www.acmicpc.net/problem/11576
 */
import kotlin.math.pow

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(convertBase(a, b, m, numbers))
}

private fun convertBase(a: Int, b: Int, m: Int, numbers: IntArray): String {
    val decimal = getDecimal(a.toDouble(), m, numbers)
    return convert(b, decimal)
}

private fun getDecimal(nary: Double, m: Int, numbers: IntArray) =
    numbers.indices.sumOf { i -> numbers[i] * nary.pow(m - i - 1) }.toInt()

private fun convert(nary: Int, decimal: Int): String {
    val s = mutableListOf<Int>()
    var n = decimal
    while (n >= nary) {
        s.add(n % nary)
        n /= nary
    }
    s.add(n)
    return s.reversed().joinToString(" ")
}
