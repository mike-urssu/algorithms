package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1551
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val repetition = reader.readLine().split(" ").map { it.toInt() }[1]
    var sequence = reader.readLine().split(",").map { it.toInt() }
    repeat(repetition) {
        sequence = getSequence(sequence)
    }

    writer.write(sequence.joinToString(","))
    writer.flush()
}

private fun getSequence(numbers: List<Int>): List<Int> {
    val sequence = mutableListOf<Int>()
    for (i in 1 until numbers.size)
        sequence.add(numbers[i] - numbers[i - 1])
    return sequence
}