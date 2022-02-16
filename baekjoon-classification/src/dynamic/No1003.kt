package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1003
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val number = reader.readLine().toInt()
        val dp = arrayListOf<IntArray>()
        dp.add(intArrayOf(1, 0))
        dp.add(intArrayOf(0, 1))
        for (i in 2 until number + 1)
            dp.add(intArrayOf(dp[i - 2][0] + dp[i - 1][0], dp[i - 2][1] + dp[i - 1][1]))

        writer.write("${dp[number][0]} ${dp[number][1]}")
        writer.newLine()
    }
    writer.flush()
}
