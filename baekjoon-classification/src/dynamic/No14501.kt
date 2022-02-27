package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/14501
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numberOfInput = readLine().toInt()
    val days = IntArray(numberOfInput)
    val prices = IntArray(numberOfInput)
    for (i in 0 until numberOfInput) {
        val tokenizer = StringTokenizer(readLine())
        days[i] = tokenizer.nextToken().toInt()
        prices[i] = tokenizer.nextToken().toInt()
    }

    val dp = IntArray(numberOfInput + 1)
    for (i in 0 until numberOfInput) {
        val nextDay = i + days[i]
        if (nextDay <= numberOfInput)
            dp[nextDay] = dp[nextDay].coerceAtLeast(dp[i] + prices[i])
        dp[i + 1] = dp[i].coerceAtLeast(dp[i + 1])
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${dp.maxOrNull()!!}")
        flush()
    }
}