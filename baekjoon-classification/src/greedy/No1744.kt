package greedy

/**
 * https://www.acmicpc.net/problem/1744
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val positiveNumbers = arrayListOf<Int>()
    val negativeNumbers = arrayListOf<Int>()
    var ones = 0
    for (i in 0 until numberOfInput) {
        val number = reader.readLine().toInt()
        if (number > 0) {
            if (number == 1)
                ones++
            else
                positiveNumbers.add(number)
        } else
            negativeNumbers.add(number)
    }
    positiveNumbers.sortDescending()
    negativeNumbers.sort()

    writer.write((sumSequence(positiveNumbers, negativeNumbers) + ones).toString())
    writer.flush()
}

fun sumSequence(positiveNumbers: List<Int>, negativeNumbers: List<Int>): Int {
    var sum = 0

    var index = 0
    while (index < positiveNumbers.size) {
        sum +=
            if (index + 1 == positiveNumbers.size)
                positiveNumbers[index++]
            else
                positiveNumbers[index++] * positiveNumbers[index++]
    }

    index = 0
    while (index < negativeNumbers.size) {
        sum +=
            if (index + 1 == negativeNumbers.size)
                negativeNumbers[index++]
            else
                negativeNumbers[index++] * negativeNumbers[index++]
    }
    return sum
}
