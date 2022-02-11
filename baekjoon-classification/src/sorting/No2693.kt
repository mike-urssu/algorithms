package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2693
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var testCase = reader.readLine().toInt()
    while (testCase-- > 0) {
        val numbers = reader.readLine().split(' ').map { it.toInt() }.sortedDescending()
        writer.write(numbers[2].toString())
        writer.newLine()
    }
    writer.flush()
}
