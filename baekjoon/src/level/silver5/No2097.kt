package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2097
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    var count: Int

    if (number in 1..4) {
        count = 4
    } else if (number in 5..6) {
        count = 6
    } else {
        var from = 5
        var to = 6
        var increment = 3
        count = 6

        while (true) {
            if (number in from..to) {
                break
            }
            from = to + 1
            to += increment
            count += 2

            if (number in from..to) {
                break
            }
            from = to + 1
            to += increment
            count += 2

            increment++
        }
    }
    writer.write("$count")
    writer.flush()
}