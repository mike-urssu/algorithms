package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11399
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val people = reader.readLine().toInt()
    val minutes = reader.readLine().split(' ').map { it.toInt() }.sorted()
    var sum = 0
    for (i in 0 until people)
        sum += minutes[i] * (people - i)
    writer.write(sum.toString())
    writer.flush()
}
