package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1085
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    if (numbers[0] <= numbers[2]) {
        val minX = numbers[0].coerceAtMost(numbers[2] - numbers[0])
        if (numbers[1] <= numbers[3]) {
            writer.write("${minX.coerceAtMost(numbers[1].coerceAtMost(numbers[3] - numbers[1]))}")
        } else {
            writer.write("${minX.coerceAtMost(numbers[1] - numbers[3])}")
        }
    } else {
        val minY = numbers[0].coerceAtMost(numbers[2] - numbers[0])
        if (numbers[1] <= numbers[3]) {
            writer.write("${minY.coerceAtMost(numbers[0] - numbers[2])}")
        } else {
            writer.write("${minY.coerceAtMost((numbers[0] - numbers[2]) + (numbers[1] - numbers[3]))}")
        }
    }
    writer.flush()
}