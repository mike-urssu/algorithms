package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1806
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val s = reader.readLine().split(" ").map { it.toInt() }[1]
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val accSum = IntArray(numbers.size + 1)
    for (i in 1 until accSum.size) {
        accSum[i] = accSum[i - 1] + numbers[i - 1]
    }

    var lowIndex = 0
    var highIndex = 1
    var length = Int.MAX_VALUE

    while (highIndex < accSum.size) {
        if (accSum[highIndex] - accSum[lowIndex] < s) {
            highIndex++
        } else {
            length = length.coerceAtMost(highIndex - lowIndex)
            lowIndex++
        }
    }

    if (length == Int.MAX_VALUE) {
        writer.write("0")
    } else {
        writer.write("$length")
    }
    writer.flush()
}