package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10872
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    if (number == 0) {
        writer.write("1")
    } else {
        var mul = 1
        for (i in 1..number) {
            mul *= i
        }
        writer.write("$mul")
    }
    writer.flush()
}