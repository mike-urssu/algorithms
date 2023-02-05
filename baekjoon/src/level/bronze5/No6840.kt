package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/6840
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers =
        intArrayOf(reader.readLine().toInt(), reader.readLine().toInt(), reader.readLine().toInt()).sortedArray()
    writer.write("${numbers[1]}")
    writer.flush()
}
