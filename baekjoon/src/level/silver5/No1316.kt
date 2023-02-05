package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1316
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var count = 0

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val word = reader.readLine()
        if (isGroup(word)) {
            count++
        }
    }

    writer.write("$count")
    writer.flush()
}

private fun isGroup(word: String): Boolean {
    val characters = mutableSetOf<Char>()

    var previousCharacter = word[0]
    characters.add(word[0])
    for (i in 1 until word.length) {
        if (characters.contains(word[i]) && previousCharacter != word[i]) {
            return false
        } else {
            characters.add(word[i])
        }
        previousCharacter = word[i]
    }
    return true
}