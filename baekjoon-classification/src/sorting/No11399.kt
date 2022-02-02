package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11399
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine().toInt()
    val numbers = reader.readLine().split(' ').map { it.toInt() }

    val sortedNumbers = mutableListOf<Int>()
    sortedNumbers.add(numbers[0])
    for (i in 1 until numbers.size) {
        var index = 0
        val number = numbers[i]
        for (j in sortedNumbers.size - 1 downTo 0) {
            if (sortedNumbers[j] <= number) {
                index = j + 1
                break
            }
        }
        sortedNumbers.add(index, number)
    }

    var sum = 0
    var size = sortedNumbers.size
    for (i in sortedNumbers.indices)
        sum += sortedNumbers[i] * size--

    writer.write(sum.toString())
    writer.flush()
}
