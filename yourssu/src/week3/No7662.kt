package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Collections
import java.util.SortedMap
import java.util.TreeMap

/**
 * https://www.acmicpc.net/problem/7662
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        getMinAndMax()
    }
    writer.flush()
}

private fun getMinAndMax() {
    val numbers: SortedMap<Int, Int> = TreeMap(Collections.reverseOrder())

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val input = reader.readLine().split(" ")
        val command = input[0]
        val number = input[1].toInt()

        if (command == "I")
            numbers[number] = numbers.getOrDefault(number, 0) + 1
        else {
            if (numbers.isNotEmpty()) {
                if (number == 1) {
                    val max = numbers.firstKey()
                    if (numbers[max] == 1)
                        numbers.remove(max)
                    else
                        numbers[max] = numbers[max]!! - 1
                } else {
                    val min = numbers.lastKey()
                    if (numbers[min] == 1)
                        numbers.remove(min)
                    else
                        numbers[min] = numbers[min]!! - 1
                }
            }
        }
    }

    if (numbers.isEmpty())
        writer.write("EMPTY")
    else
        writer.write("${numbers.firstKey()} ${numbers.lastKey()}")
    writer.newLine()
}