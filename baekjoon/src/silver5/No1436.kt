package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1436
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val index = reader.readLine().toInt()
    var count = 0
    var number666 = 666

    while (true) {
        if (number666.toString().contains("666")) {
            count++
            if (count == index) {
                break
            }
        }
        number666++
    }

    writer.write("$number666")
    writer.flush()
}