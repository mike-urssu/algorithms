package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11726
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val dp = IntArray(1001)
    dp[1] = 1
    dp[2] = 2
    val number = reader.readLine().toInt()
    for (i in 3..number)
        dp[i] = (dp[i - 2] + dp[i - 1]) % 10007

    writer.write(dp[number].toString())
    writer.flush()
}