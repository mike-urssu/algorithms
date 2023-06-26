package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/11053
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(BufferedWriter(OutputStreamWriter(System.out))) {
        val numberOfInput = readLine().toInt()
        val tokenizer = StringTokenizer(readLine())
        val numbers = IntArray(numberOfInput) {
            tokenizer.nextToken().toInt()
        }

        val dp = IntArray(numberOfInput) { 1 }
        for (i in 1 until numberOfInput) {
            val number = numbers[i]
            for (j in i - 1 downTo 0) {
                if (numbers[j] < number) {
                    dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
                }
            }
        }

        write(dp.maxOrNull().toString())
        flush()
    }
}