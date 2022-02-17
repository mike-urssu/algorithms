package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1463
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val dp = IntArray(1000001) { -1 }
    dp[0] = 0
    dp[1] = 0
    val number = reader.readLine().toInt()
    writer.write(getCount(dp, number).toString())
    writer.flush()
}

private fun getCount(dp: IntArray, number: Int): Int {
    if (dp[number] == -1) {
        if (number % 6 == 0)
            dp[number] = getCount(dp, number / 3).coerceAtMost(
                getCount(dp, number / 2).coerceAtMost(
                    getCount(
                        dp,
                        number - 1
                    )
                )
            ) + 1
        else if (number % 3 == 0)
            dp[number] = getCount(dp, number / 3).coerceAtMost(getCount(dp, number - 1)) + 1
        else if (number % 2 == 0)
            dp[number] = getCount(dp, number / 2).coerceAtMost(getCount(dp, number - 1)) + 1
        else
            dp[number] = getCount(dp, number - 1) + 1
    }
    return dp[number]
}