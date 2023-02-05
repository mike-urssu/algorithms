package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1431
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val serialNumbers = Array(numberOfInput) { "" }
    for (i in 0 until numberOfInput)
        serialNumbers[i] = reader.readLine()

    val comparator = Comparator<String> { it, other ->
        if (it.length != other.length)
            it.length.compareTo(other.length)
        else {
            val sumOfIt = getSumOfDigit(it)
            val sumOfOther = getSumOfDigit(other)
            if (sumOfIt == sumOfOther)
                it.compareTo(other)
            else
                sumOfIt - sumOfOther
        }
    }
    serialNumbers.sortWith(comparator)

    for (serialNumber in serialNumbers) {
        writer.write(serialNumber)
        writer.newLine()
    }
    writer.flush()
}

private fun getSumOfDigit(serialNumber: String): Int {
    var sum = 0
    for (character in serialNumber) {
        if (character.isDigit())
            sum += character.digitToInt()
    }
    return sum
}
