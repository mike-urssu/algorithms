package tags.math

/**
 * https://www.acmicpc.net/problem/2981
 */
import java.util.SortedSet
import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { readln().toInt() }.sortedArrayDescending()

    val diff = IntArray(n - 1) { i -> numbers[i] - numbers[i + 1] }
    val gcd = diff.reduce { n1, n2 -> gcd(n1, n2) }

    val factors = getFactors(gcd)
    factors.remove(1)
    println(factors.joinToString(" "))
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}

private fun getFactors(n: Int): SortedSet<Int> {
    val factors = sortedSetOf<Int>()
    (1..sqrt(n.toDouble()).toInt())
        .filter { i -> n % i == 0 }
        .forEach { i ->
            factors.add(i)
            factors.add(n / i)
        }
    return factors
}
