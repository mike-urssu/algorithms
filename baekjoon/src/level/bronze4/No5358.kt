package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5358
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLines()
        .forEach { writer.write("${getNewName(it)} \n") }
    writer.flush()
}

private fun getNewName(name: String) = name.map {
    when (it) {
        'e' -> {
            'i'
        }

        'i' -> {
            'e'
        }

        'I' -> {
            'E'
        }

        'E' -> {
            'I'
        }

        else -> {
            it
        }
    }
}.joinToString("")
