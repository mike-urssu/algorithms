package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5554
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var seconds = 0
    repeat(4) { seconds += reader.readLine().toInt() }
    writer.write("${seconds / 60}\n")
    writer.write("${seconds % 60}\n")
    writer.flush()
}
