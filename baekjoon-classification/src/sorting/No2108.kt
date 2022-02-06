package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.stream.Collectors
import kotlin.math.roundToInt

/**
 * https://www.acmicpc.net/problem/2108
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val numbers = IntArray(numberOfInput)
    for (i in 0 until numberOfInput)
        numbers[i] = reader.readLine().toInt()
    numbers.sort()

    var sum = 0
    for (number in numbers)
        sum += number
    writer.write((sum / numberOfInput.toDouble()).roundToInt().toString())
    writer.newLine()

    writer.write(numbers[numbers.size / 2].toString())
    writer.newLine()

    val countOfNumbers = HashMap<Int, Int>()
    for (number in numbers)
        countOfNumbers[number] = countOfNumbers.getOrDefault(number, 0) + 1
    val counts = countOfNumbers.entries.stream()
        .map {
            intArrayOf(it.key, it.value)
        }.collect(Collectors.toList())
        .sortedWith(compareBy({ -it[1] }, { it[0] }))
    if (counts.size > 1) {
        if (counts[0][1] > counts[1][1])
            writer.write(counts[0][0].toString())
        else
            writer.write(counts[1][0].toString())
    } else
        writer.write(counts[0][0].toString())
    writer.newLine()

    writer.write((numbers[numbers.size - 1] - numbers[0]).toString())
    writer.newLine()
    writer.flush()
}
