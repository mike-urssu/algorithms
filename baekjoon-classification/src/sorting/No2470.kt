package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2470
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val numbers = reader.readLine().split(' ').map { it.toInt() }.sorted()
    var low = 0
    var lowIndex = 0
    var high = numbers.size - 1
    var highIndex = numbers.size - 1
    var lowestSum = Int.MAX_VALUE
    while (lowIndex != highIndex) {
        val sum = numbers[lowIndex] + numbers[highIndex]

        val absSum = kotlin.math.abs(sum)
        if (absSum < lowestSum) {
            lowestSum = absSum
            low = lowIndex
            high = highIndex
        }

        if (sum < 0) lowIndex++
        else highIndex--
    }

    writer.write("${numbers[low]} ${numbers[high]}")
    writer.flush()
}
