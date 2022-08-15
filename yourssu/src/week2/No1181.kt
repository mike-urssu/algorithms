package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1181
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val words = Array(numberOfInput) { reader.readLine() }

    words.sortWith { it, other ->
        if (it.length == other.length)
            it.compareTo(other)
        else
            it.length - other.length
    }

    words.distinct().forEach {
        writer.write(it)
        writer.newLine()
    }
    writer.flush()
}