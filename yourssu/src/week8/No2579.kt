package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2579
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val stairs = IntArray(301)
    for (i in 1 .. numberOfInput) {
        stairs[i] = reader.readLine().toInt()
    }

    val dp = IntArray(301)
    dp[1] = stairs[1]
    dp[2] = stairs[1] + stairs[2]
    for (i in 3 until stairs.size) {
        dp[i] = dp[i - 2].coerceAtLeast(dp[i - 3] + stairs[i - 1]) + stairs[i]
    }

    writer.write("${dp[numberOfInput]}")
    writer.flush()
}