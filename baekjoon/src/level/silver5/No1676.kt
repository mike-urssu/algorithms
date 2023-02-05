package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1676
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()

    var fives = 0
    for (i in 1..number) {
        var remainder = i
        while (remainder % 5 == 0) {
            fives++
            remainder /= 5
        }
    }

    writer.write("$fives")
    writer.flush()
}