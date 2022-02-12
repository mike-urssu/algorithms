package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1449
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val lengthOfTape = reader.readLine().split(' ').map { it.toInt() }[1]
    val distances = reader.readLine().split(' ').map { it.toInt() }.sorted()

    var count = 0
    var coverage = 0
    for (distance in distances) {
        if (distance > coverage) {
            coverage = distance + lengthOfTape - 1
            count++
        }
    }
    writer.write(count.toString())
    writer.flush()
}
