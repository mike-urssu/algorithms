package level.bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1032
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val commands = Array<String>(numberOfInput) { reader.readLine() }

    for (i in 0 until commands[0].length) {
        if (commands.all { it[i] == commands[0][i] }) {
            writer.write("${commands[0][i]}")
        } else {
            writer.write("?")
        }
    }

    writer.flush()
}