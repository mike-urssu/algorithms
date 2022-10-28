package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11022
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) { i ->
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        writer.write("Case #${i + 1}: ${numbers[0]} + ${numbers[1]} = ${numbers[0] + numbers[1]}\n")
    }
    writer.flush()
}