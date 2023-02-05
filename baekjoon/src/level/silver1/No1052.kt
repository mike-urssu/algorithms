package level.silver1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1052
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    var sum = numbers[0]
    while (sum.countOneBits() > numbers[1]) {
        sum++
    }

    writer.write("${sum - numbers[0]}")
    writer.flush()
}