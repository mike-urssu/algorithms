package tags.math

/**
 * https://www.acmicpc.net/problem/4375
 */
import java.math.BigInteger

fun main() {
    while (true) {
        val n = (readlnOrNull() ?: break).toBigInteger()
        println(getLength(n))
    }
}

private fun getLength(n: BigInteger): Int {
    var value = BigInteger.ONE
    while (value.mod(n) != BigInteger.ZERO) {
        value = value * BigInteger.TEN + BigInteger.ONE
    }
    return value.toString().length
}
