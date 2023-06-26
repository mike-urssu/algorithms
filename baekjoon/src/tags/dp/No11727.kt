package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11727
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val number = readLine().toInt()
    val dp = IntArray(1001)
    dp[1] = 1
    dp[2] = 3
    for (i in 3..number)
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${dp[number]}")
        flush()
    }
}