package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.SortedSet
import java.util.TreeSet

/**
 * https://www.acmicpc.net/problem/1251
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val words: SortedSet<String> = TreeSet()

    val word = reader.readLine()
    val size = word.length

    for (i in 0..size - 2) {
        for (j in i + 1 until size - 1) {
            val first = word.substring(0, i + 1).reversed()
            val second = word.substring(i + 1, j + 1).reversed()
            val third = word.substring(j + 1).reversed()
            words.add(first + second + third)
        }
    }

    writer.write(words.first())
    writer.flush()
}