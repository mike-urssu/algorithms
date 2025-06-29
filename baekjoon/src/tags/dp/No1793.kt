package tags.dp

/**
 * https://www.acmicpc.net/problem/1793
 */
import java.math.BigInteger

fun main() {
    val dp = arrayOfNulls<BigInteger>(251)
    dp[0] = BigInteger.valueOf(1)
    dp[1] = BigInteger.valueOf(1)
    dp[2] = BigInteger.valueOf(3)
    (3..250).forEach { i -> dp[i] = dp[i - 1]!!.plus(dp[i - 2]!!).plus(dp[i - 2]!!) }

    while (true) {
        val n = (readlnOrNull() ?: break).toInt()
        println(dp[n])
    }
}
