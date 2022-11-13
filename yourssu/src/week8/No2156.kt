package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2156
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val wines = IntArray(numberOfInput + 1)
    repeat(numberOfInput) { i -> wines[i + 1] = reader.readLine().toInt() }

    when (numberOfInput) {
        1 -> {
            writer.write("${wines[1]}")
        }
        2 -> {
            writer.write("${wines[1] + wines[2]}")
        }
        else -> {
            val dp = IntArray(numberOfInput + 1)
            dp[1] = wines[1]
            dp[2] = wines[1] + wines[2]
            for (i in 3..numberOfInput) {
                dp[i] = dp[i - 1].coerceAtLeast(dp[i - 2] + wines[i]).coerceAtLeast(wines[i - 1] + dp[i - 3] + wines[i])
            }
            writer.write("${dp[numberOfInput]}")
        }
    }
    writer.flush()
}
