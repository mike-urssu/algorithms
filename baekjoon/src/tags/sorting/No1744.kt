package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1744
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val positiveNumbers = PriorityQueue<Int>(Comparator.reverseOrder())
    val zeroAndNegativeNumbers = PriorityQueue<Int>()
    for (i in 0 until numberOfInput) {
        val number = reader.readLine().toInt()
        if (number > 0) positiveNumbers.add(number)
        else zeroAndNegativeNumbers.add(number)
    }

    var sum = 0
    while (!zeroAndNegativeNumbers.isEmpty()) {
        while (zeroAndNegativeNumbers.size > 1) {
            val number1 = zeroAndNegativeNumbers.poll()
            val number2 = zeroAndNegativeNumbers.poll()
            sum += number1 * number2
        }
        if (!zeroAndNegativeNumbers.isEmpty()) {
            val number1 = zeroAndNegativeNumbers.poll()
            sum += number1
        }
    }

    while (!positiveNumbers.isEmpty()) {
        while (positiveNumbers.size > 1) {
            val number1 = positiveNumbers.poll()
            val number2 = positiveNumbers.poll()
            sum += (number1 * number2).coerceAtLeast(number1 + number2)
        }
        if (!positiveNumbers.isEmpty()) {
            val number1 = positiveNumbers.poll()
            sum += number1
        }
    }

    writer.write(sum.toString())
    writer.flush()
}
