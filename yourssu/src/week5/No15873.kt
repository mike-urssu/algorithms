package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/15873
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var sum = 0
    val numbers = reader.readLine()
    if (numbers[1].digitToInt() == 0) {
        sum += numbers.substring(0, 2).toInt()
        sum += numbers.substring(2).toInt()
    } else {
        sum += numbers[0].digitToInt()
        sum += numbers.substring(1).toInt()
    }
    writer.write("$sum")
    writer.flush()
}