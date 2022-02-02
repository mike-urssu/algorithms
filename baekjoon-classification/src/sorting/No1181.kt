package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1181
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val words = mutableSetOf<String>()
    for (i in 0 until numberOfInput) {
        val word = reader.readLine()
        words.add(word)
    }

    val sortedWords = words.toSortedSet { it, other ->
        if (it.length == other.length)
            it.compareTo(other)
        else
            it.length - other.length
    }

    for (word in sortedWords) {
        writer.write(word)
        writer.newLine()
    }
    writer.flush()
}
