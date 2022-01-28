package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/9237
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val trees = reader.readLine().split(' ').map { it.toInt() }.toIntArray().sortedArrayDescending()

    var days = 0
    for (i in trees.indices)
        days = days.coerceAtLeast(trees[i] + i)
    writer.write((days + 2).toString())
    writer.flush()
}
