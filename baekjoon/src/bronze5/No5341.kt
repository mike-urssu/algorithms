package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5341
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val number = reader.readLine().toInt()
        if (number == 0) {
            break
        }
        var sum = 0
        for (i in 1..number) {
            sum += i
        }
        writer.write("$sum\n")
    }
    writer.flush()
}
