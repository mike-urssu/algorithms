package tags.string

/**
 * https://www.acmicpc.net/problem/2870
 */
import java.math.BigInteger
import java.util.regex.Pattern

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
    val matcher = Pattern.compile("(\\d+)").matcher(s)
    while (matcher.find()) {
        numbers.add(matcher.group().toBigInteger())
    }
    return numbers
}
