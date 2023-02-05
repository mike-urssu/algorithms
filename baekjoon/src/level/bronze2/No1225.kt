package level.bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1225
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (a, b) = reader.readLine().split(" ")
    var mul = 0L
    for (i in a) {
        for (j in b) {
            mul += i.digitToInt() * j.digitToInt()
        }
    }
    writer.write("$mul")
    writer.flush()
}
