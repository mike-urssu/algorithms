package tags.greedy

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

    val numbers = reader.readLine().split(' ').map { it.toInt() }
    val length = numbers[1]
    val leaks = reader.readLine().split(' ').map { it.toInt() }.sorted()

    writer.write(getMinimumTapeCount(length, leaks).toString())
    writer.flush()
}

fun getMinimumTapeCount(length: Int, leaks: List<Int>): Int {
    var count = 0
    var lastLeakPoint = 0
    for (leak in leaks) {
        if (lastLeakPoint <= leak) {
            lastLeakPoint = leak + length
            count++
        }
    }
    return count
}
