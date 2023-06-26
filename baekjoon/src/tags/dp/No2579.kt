package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2579
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val stairs = IntArray(301)
    for (i in 1..numberOfInput)
        stairs[i] = reader.readLine().toInt()

    val dp = IntArray(301)
    dp[1] = stairs[1]
    dp[2] = dp[1] + stairs[2]
    for (i in 3..numberOfInput)
        dp[i] = (dp[i - 3] + stairs[i - 1]).coerceAtLeast(dp[i - 2]) + stairs[i]

    writer.write(dp[numberOfInput].toString())
    writer.flush()
}