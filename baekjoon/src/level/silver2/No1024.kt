package level.silver2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1024
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var cumulativeSum: IntArray

fun main() {
    setCumulativeSum()

    val numbers = reader.readLine().split(" ").map { it.toInt() }
    var number = -1
    var length = -1
    for (i in numbers[1]..100) {
        val remainder = (numbers[0] - cumulativeSum[i - 1])
        if (remainder >= 0 && remainder % i == 0) {
            number = remainder / i
            length = i
            break
        }
    }

    if (number != -1) {
        for (i in 0 until length) {
            writer.write("${number + i} ")
        }
    } else {
        writer.write("-1")
    }

    writer.flush()
}

private fun setCumulativeSum() {
    cumulativeSum = IntArray(100) { it }
    for (i in 2 until cumulativeSum.size) {
        cumulativeSum[i] += cumulativeSum[i - 1]
    }
}