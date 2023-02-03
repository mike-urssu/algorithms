package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2442
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    for (i in 1..number) {
        writer.write(" ".repeat(number - i))
        writer.write("*".repeat(2 * i - 1))
        writer.newLine()
    }
    writer.flush()
}
