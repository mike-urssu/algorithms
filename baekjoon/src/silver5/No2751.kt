package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2751
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = mutableListOf<Int>()

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val number = reader.readLine().toInt()
        numbers.add(number)
    }

    numbers.sorted().forEach { writer.write("$it\n") }
    writer.flush()
}
