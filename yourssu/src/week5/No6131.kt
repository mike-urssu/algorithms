package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/6131
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()

    var countOfPair = 0
    for (a in 1..500) {
        for (b in 1..500) {
            if (a.toDouble().pow(2).toInt() == b.toDouble().pow(2).toInt() + number)
                countOfPair++
        }
    }

    writer.write("$countOfPair")
    writer.flush()
}