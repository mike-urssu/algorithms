package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1912
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numberOfInput = readLine().toInt()
    val tokenizer = StringTokenizer(readLine())
    val numbers = Array(numberOfInput) {
        tokenizer.nextToken().toInt()
    }

    val dp = IntArray(numberOfInput)
    dp[0] = numbers[0]
    for (i in 1 until numberOfInput)
        dp[i] = (dp[i - 1] + numbers[i]).coerceAtLeast(numbers[i])

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${dp.maxOrNull()!!}")
        flush()
    }
}
