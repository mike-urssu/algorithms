package tags.dp

/**
 * https://www.acmicpc.net/problem/17626
 */
import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    println(getDp()[n])
}

private fun getDp(): IntArray {
    val dp = IntArray(50001)
    dp[0] = 1
    (1..50000).forEach { i ->
        val sqrt = sqrt(i.toDouble()).toInt()
        dp[i] = (sqrt downTo 1).minOf { j -> dp[j * j] + dp[i - j * j] }
    }
    return dp
}
