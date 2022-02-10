package sorting

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
        val number1 = zeroAndNegativeNumbers.poll()
        if (zeroAndNegativeNumbers.isEmpty()) {
            sum += number1
            break
        }
        val number2 = zeroAndNegativeNumbers.poll()
        sum += number1 * number2
    }

    while (!positiveNumbers.isEmpty()) {
        val number1 = positiveNumbers.poll()
        if (positiveNumbers.isEmpty()) {
            sum += number1
            break
        }
        val number2 = positiveNumbers.poll()
        sum += (number1 * number2).coerceAtLeast(number1 + number2)
    }

    writer.write(sum.toString())
    writer.flush()
}
