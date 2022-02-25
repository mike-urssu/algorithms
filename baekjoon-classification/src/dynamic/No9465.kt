package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/9465
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val testCase = readLine().toInt()
    repeat(testCase) {
        val rows = readLine().toInt()
        val scores = Array(2) {
            val tokenizer = StringTokenizer(readLine())
            IntArray(tokenizer.countTokens() + 1) { i ->
                if (i == 0) 0
                else tokenizer.nextToken().toInt()
            }
        }

        val dp = Array(2) { IntArray(rows + 1) }
        dp[0][1] = scores[0][1]
        dp[1][1] = scores[1][1]
        for (i in 2..rows) {
            dp[0][i] = dp[1][i - 2].coerceAtLeast(dp[1][i - 1]) + scores[0][i]
            dp[1][i] = dp[0][i - 2].coerceAtLeast(dp[0][i - 1]) + scores[1][i]
        }

        with(BufferedWriter(OutputStreamWriter(System.out))) {
            write("${dp[0][rows].coerceAtLeast(dp[1][rows])}")
            newLine()
            flush()
        }
    }
}