package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1193
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()

    var row = 1
    var accumulatedSum = 0
    while (number > accumulatedSum + row) {
        accumulatedSum += row
        row++
    }
    accumulatedSum += row

    val diff = accumulatedSum - number + 1
    if (row % 2 == 0) {
        writer.write("${row + 1 - diff}/$diff")
    } else {
        writer.write("$diff/${row + 1 - diff}")
    }
    writer.flush()
}