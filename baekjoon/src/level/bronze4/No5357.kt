package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5357
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val input = reader.readLine()
        writer.write("${removeConsecutiveLetters(input)}\n")
    }
    writer.flush()
}

private fun removeConsecutiveLetters(input: String): String {
    val word = StringBuilder()
    var previousCharacter = '_'
    for (character in input) {
        if (character != previousCharacter) {
            word.append(character)
            previousCharacter = character
        }
    }
    return word.toString()
}
