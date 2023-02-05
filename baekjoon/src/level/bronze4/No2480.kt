package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2480
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val dices = reader.readLine().split(" ").map { it.toInt() }
    if (dices[0] == dices[1] && dices[1] == dices[2]) {
        writer.write("${10000 + dices[0] * 1000}")
    } else if (dices[0] == dices[1]) {
        writer.write("${1000 + dices[0] * 100}")
    } else if (dices[1] == dices[2]) {
        writer.write("${1000 + dices[1] * 100}")
    } else if (dices[2] == dices[0]) {
        writer.write("${1000 + dices[2] * 100}")
    } else {
        writer.write("${dices.maxOf { it } * 100}")
    }
    writer.flush()
}