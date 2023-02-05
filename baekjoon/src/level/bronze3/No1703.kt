package level.bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1703
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        if (numbers == listOf(0)) {
            break
        }

        val age = numbers[0]
        var leaves = 1
        repeat(age) { i ->
            val growth = numbers.subList(2 * i + 1, 2 * i + 3)
            leaves = leaves * growth[0] - growth[1]
        }
        writer.write("$leaves\n")
    }
    writer.flush()
}
