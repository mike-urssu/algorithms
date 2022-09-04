package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/13900
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    var sum = numbers.sum().toLong()
    var total = 0L
    for (i in 0 until numbers.size - 1) {
        sum -= numbers[i]
        total += numbers[i] * sum
    }

    writer.write("$total")
    writer.flush()
}