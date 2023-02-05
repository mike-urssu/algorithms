package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11651
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val positions = arrayListOf<List<Int>>()
    for (i in 0 until numberOfInput) {
        val position = reader.readLine().split(' ').map { it.toInt() }
        positions.add(position)
    }

    positions.sortWith(compareBy({ it[1] }, { it[0] }))

    for (position in positions) {
        writer.write("${position[0]} ${position[1]}")
        writer.newLine()
    }
    writer.flush()
}
