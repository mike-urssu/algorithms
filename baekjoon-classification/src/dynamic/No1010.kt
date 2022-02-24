package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1010
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numberOfInput = readLine().toInt()
    val dp = Array(30) { IntArray(30) }
    for (i in dp.indices) {
        dp[i][0] = 1
        dp[i][i] = 1
    }

    for (i in 2 until dp.size) {
        for (j in 1 until dp.size)
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
    }

    repeat(numberOfInput) {
        val numbers = readLine().split(' ').map { it.toInt() }
        with(BufferedWriter(OutputStreamWriter(System.out))) {
            write("${dp[numbers[1]][numbers[0]]}")
            newLine()
            flush()
        }
    }
}

/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numberOfInput = readLine().toInt()

    repeat(numberOfInput) {
        val numbers = readLine().split(' ').map { it.toInt() }

        var combination = BigInteger.valueOf(1)
        for (i in 1..numbers[1])
            combination = combination.multiply(BigInteger.valueOf(i.toLong()))
        for (i in 1..numbers[0])
            combination = combination.divide(BigInteger.valueOf(i.toLong()))
        for (i in 1..numbers[1] - numbers[0])
            combination = combination.divide(BigInteger.valueOf(i.toLong()))

        with(BufferedWriter(OutputStreamWriter(System.out))) {
            write("$combination")
            newLine()
            flush()
        }
    }
}
*/
