package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11057
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val number = readLine().toInt()
    val countByDigits = Array(number + 1) { IntArray(10) }
    for (i in 0..9)
        countByDigits[1][i] = 1

    for (i in 2..number) {
        for (j in 0..9) {
            for (k in j..9)
                countByDigits[i][j] += countByDigits[i - 1][k] % 10007
        }
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        var count = 0
        for (i in 0..9)
            count = (count + countByDigits[number][i]) % 10007
        write("$count")
        flush()
    }
}