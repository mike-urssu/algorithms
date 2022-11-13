package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/12852
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var counts: IntArray
private lateinit var sequence: IntArray

fun main() {
    val number = reader.readLine().toInt()
    counts = IntArray(number + 1) { -1 }
    counts[1] = 0
    sequence = IntArray(number + 1)

    setCounts(number)

    writer.write("${counts[number]}\n")

    var index = number
    while (index != 0) {
        writer.write("$index ")
        index = sequence[index]
    }
    writer.flush()
}

private fun setCounts(number: Int) {
    var a = Int.MAX_VALUE
    var b = Int.MAX_VALUE
    if (number % 3 == 0) {
        a = getCount(number / 3)
    }
    if (number % 2 == 0) {
        b = getCount(number / 2)
    }
    val c = getCount(number - 1)

    if (a <= b && a <= c) {
        sequence[number] = number / 3
    } else if (b <= c) {
        sequence[number] = number / 2
    } else {
        sequence[number] = number - 1
    }

    counts[number] = a.coerceAtMost(b).coerceAtMost(c) + 1
}

private fun getCount(number: Int): Int {
    if (number == 0) {
        return -1
    }
    if (counts[number] == -1) {
        setCounts(number)
    }
    return counts[number]
}