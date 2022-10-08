package bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1264
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    while (true) {
        val sentence = reader.readLine()
        if (sentence == "#") {
            break
        }
        writer.write("${sentence.count { vowels.contains(it.lowercaseChar()) }}\n")
    }
    writer.flush()
}