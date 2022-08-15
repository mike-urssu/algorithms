package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5052
 */

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()

    repeat(testCase) {
        val numberOfInput = reader.readLine().toInt()
        val sortedNumbers = Array<String>(numberOfInput) { reader.readLine() }.sortedDescending()
        var isConsistent = true

        for (i in 0 until sortedNumbers.size - 1) {
            if (sortedNumbers[i].startsWith(sortedNumbers[i + 1])) {
                isConsistent = false
                break
            }
        }

        writer.write(if (isConsistent) "YES" else "NO")
        writer.newLine()
    }

    writer.flush()
}