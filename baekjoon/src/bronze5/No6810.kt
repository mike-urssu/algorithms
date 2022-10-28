package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/6810
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = "9780921418"

    var sum = 0
    for (i in numbers.indices) {
        sum += if (i % 2 == 0) {
            numbers[i].digitToInt()
        } else {
            numbers[i].digitToInt() * 3
        }
    }
    sum += reader.readLine().toInt()
    sum += reader.readLine().toInt() * 3
    sum += reader.readLine().toInt()

    writer.write("The 1-3-sum is $sum")
    writer.flush()
}