package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11004
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val index = reader.readLine().split(' ').map { it.toInt() }[1] - 1
    val numbers = reader.readLine().split(' ').map { it.toInt() }.sorted()
    writer.write(numbers[index].toString())
    writer.flush()
}
