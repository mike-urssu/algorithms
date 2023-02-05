package level.bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1159
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val firstNames = sortedMapOf<Char, Int>()
    repeat(numberOfInput) {
        val firstName = reader.readLine()[0]
        firstNames[firstName] = firstNames.getOrDefault(firstName, 0) + 1
    }

    if (firstNames.values.all { it < 5 }) {
        writer.write("PREDAJA")
    } else {
        firstNames
            .filter { it.value >= 5 }.keys
            .forEach { writer.write("$it") }
    }
    writer.flush()
}
