package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2443
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    for (i in 0 until number) {
        writer.write(" ".repeat(i))
        writer.write("*".repeat((number - i) * 2 - 1))
        writer.newLine()
    }
    writer.flush()
}
