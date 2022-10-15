package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1145
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    var multiple = numbers.minOf { it }
    while (true) {
        var count = 0
        for (number in numbers) {
            if (multiple % number == 0) {
                count++
            }
        }
        if (count >= 3) {
            break
        }

        multiple++
    }

    writer.write("$multiple")
    writer.flush()
}