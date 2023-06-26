package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1149
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val dp = arrayListOf<IntArray>()
    dp.add(reader.readLine().split(' ').map { it.toInt() }.toIntArray())
    for (i in 1 until numberOfInput) {
        val house = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        dp.add(
            intArrayOf(
                dp[i - 1][1].coerceAtMost(dp[i - 1][2]) + house[0],
                dp[i - 1][0].coerceAtMost(dp[i - 1][2]) + house[1],
                dp[i - 1][0].coerceAtMost(dp[i - 1][1]) + house[2]
            )
        )
    }

    val costs = dp[numberOfInput - 1]
    writer.write(costs[0].coerceAtMost(costs[1]).coerceAtMost(costs[2]).toString())
    writer.flush()
}