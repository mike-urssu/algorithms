package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1015
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val numbers = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
    val sortedNumbers = numbers.sorted()
    val arrayP = IntArray(numberOfInput)

    for (i in sortedNumbers.indices) {
        val index = numbers.indexOf(sortedNumbers[i])
        numbers[index] = -1
        arrayP[index] = i
    }

    for (number in arrayP)
        writer.write("$number ")
    writer.flush()
}
