package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11650
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

    pairs.sortWith { it, other ->
        if (it[0] == other[0])
            it[1] - other[1]
        else
            it[0] - other[0]
    }

    for (pair in pairs) {
        writer.write("${pair[0]} ${pair[1]}")
        writer.newLine()
    }
    writer.flush()
}
