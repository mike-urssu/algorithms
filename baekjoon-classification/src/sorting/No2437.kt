package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2437
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val numbers = reader.readLine().split(' ').map { it.toInt() }.sorted()
    var sum = 0
    for (number in numbers) {
        if (sum + 1 < number)
            break
        else
            sum += number
    }
    writer.write((sum + 1).toString())
    writer.flush()
}
