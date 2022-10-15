package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1157
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val word = reader.readLine().uppercase().toCharArray().sortedArray()

    val characters = mutableMapOf<Char, Int>()
    val countOfCharacter = mutableListOf<Int>()

    val distinctCharacters = word.distinct()
    for (character in distinctCharacters) {
        val count = word.lastIndexOf(character) - word.indexOf(character) + 1
        characters[character] = count
        countOfCharacter.add(count)
    }

    val max = countOfCharacter.maxOf { it }
    if (countOfCharacter.indexOf(max) == countOfCharacter.lastIndexOf(max)) {
        for (key in characters.keys) {
            if (characters[key] == max) {
                writer.write("$key")
                break
            }
        }
    } else {
        writer.write("?")
    }
    writer.flush()
}