package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine().toInt()
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val sortedNumbers = numbers.distinct().sorted()

    numbers.forEach { writer.write("${sortedNumbers.indexOf(it)} ") }

    writer.flush()
}