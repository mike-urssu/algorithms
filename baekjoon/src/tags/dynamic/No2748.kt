package tags.dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2748
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val fibonacci = LongArray(91)
    fibonacci[1] = 1
    fibonacci[2] = 1
    for (i in 3 until fibonacci.size)
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1]

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${fibonacci[readLine().toInt()]}")
        flush()
    }
}
