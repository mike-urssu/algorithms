package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1547
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    var position = 1

    repeat(numberOfInput) {
        val cups = reader.readLine().split(" ").map { it.toInt() }
        if (cups[0] == position) {
            position = cups[1]
        } else if (cups[1] == position) {
            position = cups[0]
        }
    }

    writer.write("$position")
    writer.flush()
}
