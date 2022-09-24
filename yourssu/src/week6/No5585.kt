package week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5585
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var change = 1000 - reader.readLine().toInt()

    var countOfCoin = 0
    val values = intArrayOf(500, 100, 50, 10, 5, 1)
    for (value in values) {
        countOfCoin += change / value
        change %= value
    }

    writer.write("$countOfCoin")
    writer.flush()
}