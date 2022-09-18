package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1475
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val digits = reader.readLine()
    writer.write("${getRequiredSets(digits)}")
    writer.flush()
}

private fun getRequiredSets(digits: String): Int {
    val countOfNumbers = mutableMapOf<Int, Int>()
    updateDigits(countOfNumbers)
    var count = 1

    for (digit in digits) {
        var number = digit.digitToInt()
        if (number == 9)
            number = 6

        if (countOfNumbers[number] == 0) {
            updateDigits(countOfNumbers)
            count++
        }
        countOfNumbers[number] = countOfNumbers[number]!! - 1
    }

    return count
}

private fun updateDigits(countOfNumbers: MutableMap<Int, Int>) {
    for (i in 0..8)
        countOfNumbers[i] = countOfNumbers.getOrDefault(i, 0) + 1
    countOfNumbers[6] = countOfNumbers[6]!! + 1
}