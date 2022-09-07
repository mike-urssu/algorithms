package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2004
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toLong() }
    val number1 = numbers[0]
    val number2 = numbers[1]

    val countOfTwo =
        getCountOfNumber(2, number1) - getCountOfNumber(2, number2) - getCountOfNumber(2, number1 - number2)

    val countOfFive =
        getCountOfNumber(5, number1) - getCountOfNumber(5, number2) - getCountOfNumber(5, number1 - number2)

    writer.write("${countOfTwo.coerceAtMost(countOfFive)}")
    writer.flush()
}


private fun getCountOfNumber(number: Int, given: Long): Long {
    var count = 0L

    var powerOfNumber = number.toLong()
    while (given / powerOfNumber != 0L) {
        count += given / powerOfNumber
        powerOfNumber *= number
    }

    return count
}