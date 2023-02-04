package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2018
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var count = 0

    val number = reader.readLine().toInt()
    var lowIndex = 0
    var highIndex = 0

    while (lowIndex <= number && highIndex <= number) {
        var sum = 0
        for (i in lowIndex..highIndex) {
            sum += i
        }

        if (sum < number) {
            highIndex++
        } else if (sum == number) {
            highIndex++
            count++
        } else {
            lowIndex++
        }
    }

    writer.write("$count")
    writer.flush()
}