package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1284
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val characters = reader.readLine()
        if (characters == "0") {
            break
        }

        var width = characters.length + 1
        characters.forEach { character ->
            width += when (character) {
                '1' -> {
                    2
                }
                '0' -> {
                    4
                }
                else -> {
                    3
                }
            }
        }
        writer.write("$width \n")
    }
    writer.flush()
}
