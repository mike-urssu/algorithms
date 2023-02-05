package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5300
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    for (i in 1..number) {
        writer.write("$i ")
        if (i % 6 == 0)
            writer.write("Go! ")
    }
    if (number % 6 != 0) {
        writer.write("Go! ")
    }
    writer.flush()
}
