package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/4101
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val line = reader.readLine().split(" ").map { it.toInt() }
        if (line[0] == 0 && line[1] == 0)
            break
        writer.write(if (line[0] > line[1]) "Yes" else "No")
        writer.newLine()
    }
    writer.flush()
}