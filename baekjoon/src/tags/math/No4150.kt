package tags.math

/**
 * https://www.acmicpc.net/problem/4150
 */
import java.math.BigInteger

fun main() {
    val n = readln().toInt()
    val values = arrayOf(BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE)
    for (i in 3..n) {
        values[i % 3] = values[(i + 1) % 3] + values[(i + 2) % 3]
    }
    println(values[n % 3])
}
