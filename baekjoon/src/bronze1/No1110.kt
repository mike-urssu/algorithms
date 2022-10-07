package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1110
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val givenNumber = reader.readLine().toInt()
    var number = givenNumber

    var cycle = 0
    while (true) {
        cycle++
        number = cycleNumber(number)
        if (number == givenNumber) {
            break
        }
    }

    writer.write("$cycle")
    writer.flush()
}

private fun cycleNumber(number: Int): Int {
    var sum = 0
    String.format("%02d", number).forEach { sum += it.digitToInt() }
    sum = sum % 10 + number % 10 * 10
    return sum
}