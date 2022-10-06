package bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1009
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        var mod = 1
        repeat(numbers[1]) {
            mod = mod * numbers[0] % 10
        }
        if (mod == 0) {
            writer.write("10\n")
        } else {
            writer.write("$mod\n")
        }
    }
    writer.flush()
}