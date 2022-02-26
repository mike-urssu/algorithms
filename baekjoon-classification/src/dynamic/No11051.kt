package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/11051
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val tokenizer = StringTokenizer(readLine())
    val n = tokenizer.nextToken().toInt()
    val r = tokenizer.nextToken().toInt()

    val combination = Array(n + 1) { i -> IntArray(n + 1) }
    for (i in 0..n)
        combination[1][i] = 1
    for (i in 0..n) {
        combination[i][0] = 1
        combination[i][i] = 1
    }

    for (i in 2..n) {
        for (j in 1 until i)
            combination[i][j] = (combination[i - 1][j - 1] + combination[i - 1][j]) % 10007
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${combination[n][r]}")
        flush()
    }
}