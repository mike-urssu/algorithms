package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/9461
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val testCase = readLine().toInt()
    val dp = LongArray(101)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2
    for (i in 6 until dp.size)
        dp[i] = dp[i - 5] + dp[i - 1]

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        repeat(testCase) {
            val number = readLine().toInt()
            write("${dp[number]}")
            newLine()
        }
        flush()
    }
}