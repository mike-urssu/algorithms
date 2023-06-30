package tags.string

/**
 * https://www.acmicpc.net/problem/2870
 */
import java.math.BigInteger

fun main() {
    val n = readln().toInt()
    val numbers = mutableListOf<BigInteger>()
    repeat(n) {
        val s = readln()
        numbers.addAll(getNumbers(s))
    }
    numbers.sorted().forEach { println(it) }
}

private fun getNumbers(s: String): List<BigInteger> {
    val numbers = mutableListOf<BigInteger>()
    var startIndex = 0
    var endIndex = 0
    while (endIndex < s.length) {
        if (s[endIndex].isDigit()) {
            endIndex++
        } else {
            if (startIndex == endIndex) {
                startIndex++
                endIndex++
            } else {
                numbers.add(s.substring(startIndex, endIndex).toBigInteger())
                startIndex = ++endIndex
            }
        }
    }
    if (s.last().isDigit()) {
        numbers.add(s.substring(startIndex, endIndex).toBigInteger())
    }
    return numbers
}
