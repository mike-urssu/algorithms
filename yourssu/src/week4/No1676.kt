package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1676
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()

    var count = 0
    var multipleOfFive = 5
    while (multipleOfFive <= number) {
        count += countFactorFive(multipleOfFive)
        multipleOfFive += 5
    }

    writer.write("$count\n")
    writer.flush()
}

private fun countFactorFive(number: Int): Int {
    var count = 0

    var powerOfFive = 5
    while (number % powerOfFive == 0) {
        count++
        powerOfFive *= 5
    }

    return count
}