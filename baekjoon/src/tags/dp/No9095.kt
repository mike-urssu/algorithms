package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/9095
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val dp = IntArray(11)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4..10)
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]

    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val number = reader.readLine().toInt()
        writer.write(dp[number].toString())
        writer.newLine()
    }
    writer.flush()
}