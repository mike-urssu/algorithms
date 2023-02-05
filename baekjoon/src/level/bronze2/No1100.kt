package level.bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1100
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var count = 0
    repeat(8) { i ->
        val line = reader.readLine()
        line.forEachIndexed { index, character ->
            if (character == 'F') {
                if (i % 2 == 0 && index % 2 == 0) {
                    count++
                } else if (i % 2 == 1 && index % 2 == 1) {
                    count++
                }
            }
        }
    }
    writer.write("$count")
    writer.flush()
}