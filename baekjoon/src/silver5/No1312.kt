package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1312
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    var mod = numbers[0] % numbers[1] * 10
    repeat(numbers[2] - 1) {
        mod = mod % numbers[1] * 10
    }
    writer.write("${mod / numbers[1]}")
    writer.flush()
}