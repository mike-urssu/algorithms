package tags.binary_search

/**
 * https://www.acmicpc.net/problem/13706
 */
import java.math.BigInteger

fun main() {
    val n = readln().toBigInteger()
    println(sqrt(n))
}

private fun sqrt(n: BigInteger): BigInteger {
    var low = BigInteger.ZERO
    var high = BigInteger("9".repeat(800))
    while (low.plus(BigInteger.ONE) < high) {
        val mid = low.plus(high).divide(BigInteger.valueOf(2))
        if (mid.pow(2) >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
