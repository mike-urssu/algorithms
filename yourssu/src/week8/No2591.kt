package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2591
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine()
    if (number.length == 1) {
        writer.write("1")
    } else if (number.length == 2) {
        if (isInBoundary(number.toInt())) {
            if (number[1] == '0') {
                writer.write("1")
            } else {
                writer.write("2")
            }
        } else {
            writer.write("1")
        }
    } else {
        val dp = IntArray(number.length)
        dp[0] = 1
        if (isInBoundary(number.substring(0, 2).toInt())) {
            if (number[1] == '0') {
                dp[1] = 1
            } else {
                dp[1] = 2
            }
        } else {
            dp[1] = 1
        }

        for (i in 2 until number.length) {
            if (number[i - 1] == '0') {
                if (number[i] == '0') {
                    break
                } else {
                    dp[i] = dp[i - 1]
                }
            } else if (number[i] == '0') {
                if (isInBoundary(number.substring(i - 1, i + 1).toInt())) {
                    dp[i] = dp[i - 2]
                } else {
                    break
                }
            } else {
                if (isInBoundary(number.substring(i - 1, i + 1).toInt())) {
                    dp[i] = dp[i - 2] + dp[i - 1]
                } else {
                    dp[i] = dp[i - 1]
                }
            }
        }
        writer.write("${dp.last()}")
    }
    writer.flush()
}

private fun isInBoundary(number: Int) = number in 1..34
