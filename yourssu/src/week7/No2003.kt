package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2003
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val n = numbers[0]
    val m = numbers[1]
    val array = reader.readLine().split(" ").map { it.toInt() }

    var count = 0
    var lowIndex = 0
    var highIndex = 0

    while (lowIndex < n && highIndex < n) {
        var sum = 0
        for (i in lowIndex..highIndex) {
            sum += array[i]
        }

        if (sum < m) {
            highIndex++
        } else if (sum == m) {
            highIndex++
            count++
        } else {
            lowIndex++
        }
    }

    writer.write("$count")
    writer.flush()
}