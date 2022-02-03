package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2720
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val units = intArrayOf(25, 10, 5, 1)

    for (i in 0 until numberOfInput) {
        var changes = reader.readLine().toInt()
        for (unit in units) {
            writer.write("${changes / unit} ")
            changes %= unit
        }
        writer.newLine()
    }
    writer.flush()
}
