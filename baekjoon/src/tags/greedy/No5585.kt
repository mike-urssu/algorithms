package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5585
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val units = arrayOf(500, 100, 50, 10, 5, 1)

    var change = 1000 - reader.readLine().toInt()
    var count = 0
    for (unit in units) {
        count += change / unit
        change %= unit
    }

    writer.write(count.toString())
    writer.flush()
}
