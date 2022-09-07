package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var countOfTwoAndFive: Array<IntArray>

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val number1 = numbers[0]
    val number2 = numbers[1].coerceAtMost(numbers[0] - numbers[1])

    setCountOfTwoAndFive(number1)

    val countOfTwo = getCountOfNumber(0, number1 - number2 + 1, number1) - getCountOfNumber(0, 1, number2)

    val countOfFive = getCountOfNumber(1, number1 - number2 + 1, number1) - getCountOfNumber(1, 1, number2)

    writer.write("${countOfTwo.coerceAtMost(countOfFive)}")
    writer.flush()
}

private fun setCountOfTwoAndFive(size: Int) {
    countOfTwoAndFive = Array(2) { IntArray(size + 1) }
    for (number in 2..size) {
        if (number % 2 == 0)
            countOfTwoAndFive[0][number] = countNumber(2, number)
        if (number % 5 == 0)
            countOfTwoAndFive[1][number] = countNumber(5, number)
    }
}

private fun countNumber(number: Int, given: Int): Int {
    var countOfNumber = 0

    var powerOfNumber = number
    while (given % powerOfNumber == 0) {
        countOfNumber++
        powerOfNumber *= number
    }

    return countOfNumber
}

private fun getCountOfNumber(index: Int, from: Int, to: Int): Int {
    var count = 0
    for (i in from..to)
        count += countOfTwoAndFive[index][i]
    return count
}