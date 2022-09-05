package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/9613
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }

        var sum = 0L
        for (i in 1 until numbers.size - 1) {
            for (j in i + 1 until numbers.size) {
                sum += getGCD(numbers[i], numbers[j])
            }
        }

        writer.write("$sum\n")
    }
    writer.flush()
}

private fun getGCD(number1: Int, number2: Int): Int {
    return if (number2 == 0)
        number1
    else
        getGCD(number2, number1 % number2)
}