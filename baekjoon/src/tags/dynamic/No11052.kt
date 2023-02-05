package tags.dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/11052
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val count = readLine().toInt()
    val tokenizer = StringTokenizer(readLine())
    val prices = IntArray(tokenizer.countTokens() + 1) { i ->
        if (i == 0) 0
        else tokenizer.nextToken().toInt()
    }

    val dp = IntArray(prices.size)
    for (i in 1 until dp.size) {
        for (j in 0 until i)
            dp[i] = dp[i].coerceAtLeast(dp[j] + prices[i - j])
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${dp[count]}")
        flush()
    }
}