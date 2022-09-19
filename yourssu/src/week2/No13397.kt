package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/13397
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val countOfGroup = reader.readLine().split(" ").map { it.toInt() }[1]
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    var lowScore = -1
    var highScore = 10000

    while (lowScore + 1 < highScore) {
        val midScore = (lowScore + highScore) / 2
        val group = getCountOfGroup(numbers, midScore)
        if (countOfGroup < group) {
            lowScore = midScore
        } else if (countOfGroup > group) {
            highScore = midScore
        } else {
            highScore = midScore
        }
    }

    writer.write("$highScore")
    writer.flush()
}

private fun getCountOfGroup(numbers: List<Int>, score: Int): Int {
    var countOfGroup = 1

    var currentIndex = 0
    var nextIndex = 0
    while (nextIndex < numbers.size) {
        if (getScore(numbers.subList(currentIndex, nextIndex + 1)) > score) {
            currentIndex = nextIndex
            countOfGroup++
        } else {
            nextIndex++
        }
    }

    return countOfGroup
}

private fun getScore(numbers: List<Int>): Int {
    return numbers.maxOf { it } - numbers.minOf { it }
}