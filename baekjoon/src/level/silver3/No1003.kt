package level.silver3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1003
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var fibonacci: Array<IntArray>

fun main() {
    setFibonacci()

    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val number = reader.readLine().toInt()
        writer.write("${fibonacci[0][number]} ${fibonacci[1][number]}\n")
    }
    writer.flush()
}

private fun setFibonacci() {
    fibonacci = Array(2) { IntArray(41) }
    fibonacci[0][0] = 1
    fibonacci[1][1] = 1
    for (i in 2..40) {
        fibonacci[0][i] = fibonacci[0][i - 1] + fibonacci[0][i - 2]
        fibonacci[1][i] = fibonacci[1][i - 1] + fibonacci[1][i - 2]
    }
}