package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2744
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val word = reader.readLine()
    for (character in word) {
        if (character in 'a'..'z') {
            writer.write(character.uppercase())
        } else {
            writer.write(character.lowercase())
        }
    }
    writer.flush()
}