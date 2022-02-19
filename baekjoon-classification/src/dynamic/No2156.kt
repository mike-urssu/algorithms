package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2156
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numberOfInput = readLine().toInt()
    val wines = IntArray(numberOfInput) {
        readLine().toInt()
    }

    val dp = IntArray(numberOfInput)
    dp[0] = wines[0]
    if (numberOfInput > 1)
        dp[1] = wines[0] + wines[1]
    if (numberOfInput > 2)
        dp[2] = (wines[0].coerceAtLeast(wines[1]) + wines[2]).coerceAtLeast(dp[1])
    for (i in 3 until dp.size)
        dp[i] = ((dp[i - 3] + wines[i - 1]).coerceAtLeast(dp[i - 2]) + wines[i]).coerceAtLeast(dp[i - 1])

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write(dp.maxOrNull().toString())
        flush()
    }
}