package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10430
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    writer.write("${(numbers[0] + numbers[1]) % numbers[2]}\n")
    writer.write("${(numbers[0] % numbers[2] + (numbers[1] % numbers[2])) % numbers[2]}\n")
    writer.write("${(numbers[0] * numbers[1]) % numbers[2]}\n")
    writer.write("${((numbers[0] % numbers[2]) * (numbers[1] % numbers[2])) % numbers[2]}")
    writer.flush()
}