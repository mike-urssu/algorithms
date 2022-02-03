package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1931
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val pairs = mutableListOf<IntArray>()
    for (i in 0 until numberOfInput) {
        val numbers = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        pairs.add(numbers)
    }
    pairs.sortWith(compareBy({ it[1] }, { it[0] }))

    var count = 0
    var endAt = 0
    for (pair in pairs) {
        if (endAt <= pair[0]) {
            endAt = pair[1]
            count++
        }
    }

    writer.write(count.toString())
    writer.flush()
}
