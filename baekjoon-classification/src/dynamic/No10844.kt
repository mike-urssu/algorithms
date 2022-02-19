package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10844
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(BufferedWriter(OutputStreamWriter(System.out))) {
        val number = readLine().toInt()
        val stairs = Array(number + 1) { i ->
            when (i) {
                0 -> LongArray(10)
                1 -> LongArray(10) { 1 }
                else -> LongArray(10) { -1 }
            }
        }

        for (i in 2..number) {
            for (j in 0..9) {
                when (j) {
                    0 -> stairs[i][j] = stairs[i - 1][1] % 1000000000
                    9 -> stairs[i][j] = stairs[i - 1][8] % 1000000000
                    else -> stairs[i][j] = (stairs[i - 1][j - 1] + stairs[i - 1][j + 1]) % 1000000000
                }
            }
        }

        val sum = (stairs[number].sum() - stairs[number][0]) % 1000000000
        write(sum.toString())
        flush()
    }
}