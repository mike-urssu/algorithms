package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2193
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val number = readLine().toInt()
    val dp = LongArray(91)
    dp[1] = 1
    for (i in 2 until dp.size)
        dp[i] = dp[i - 2] + dp[i - 1]

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${dp[number]}")
        flush()
    }
}