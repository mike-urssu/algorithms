package bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/4589
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()

    writer.write("Gnomes:\n")
    repeat(numberOfInput) {
        val heights = reader.readLine().split(" ").map { it.toInt() }
        if (heights == heights.sorted() || heights == heights.sortedDescending()) {
            writer.write("Ordered")
        } else {
            writer.write("Unordered")
        }
        writer.newLine()
    }
    writer.flush()
}
