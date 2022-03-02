package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1699
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val number = readLine().toInt()
    val dp = IntArray(number + 1) { i -> i }

    for (i in 1..number) {
        for (j in 1..i) {
            if (j * j > i)
                break
            dp[i] = dp[i].coerceAtMost(dp[i - j * j] + 1)
        }
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${dp[number]}")
        flush()
    }
}