package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2444
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    for (i in 0 until number - 1) {
        writer.write(" ".repeat(number - i - 1))
        writer.write("*".repeat(i * 2 + 1))
        writer.newLine()
    }
    writer.write("${"*".repeat(number * 2 - 1)}\n")
    for (i in 1 until number) {
        writer.write(" ".repeat(i))
        writer.write("*".repeat((number - i) * 2 - 1))
        writer.newLine()
    }
    writer.flush()
}
