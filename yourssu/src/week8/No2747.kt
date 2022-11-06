package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2747
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()

    val fibonacci = IntArray(number + 1)
    fibonacci[1] = 1
    for (i in 2 until number + 1) {
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1]
    }

    writer.write("${fibonacci[number]}")
    writer.flush()
}
