package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1789
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val number = reader.readLine().toLong()

    var sum = 0L
    var increment = 0
    while (sum <= number)
        sum += ++increment
    writer.write((increment - 1).toString())
    writer.flush()
}
