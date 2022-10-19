package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1531
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private val picture = Array(100) { IntArray(100) }

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    repeat(numbers[0]) {
        val covers = reader.readLine().split(" ").map { it.toInt() - 1 }
        for (i in covers[0]..covers[2]) {
            for (j in covers[1]..covers[3]) {
                picture[i][j]++
            }
        }
    }

    var count = 0
    for (i in 0 until 100) {
        for (j in 0 until 100) {
            if (picture[i][j] > numbers[1]) {
                count++
            }
        }
    }

    writer.write("$count")
    writer.flush()
}