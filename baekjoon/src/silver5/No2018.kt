package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2018
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var leftIndex = 1
    var rightIndex = 1
    var sum = 1
    var count = 0

    val number = reader.readLine().toInt()
    while (rightIndex <= number) {
        if (sum < number) {
            sum += ++rightIndex
        } else if (sum == number) {
            count++
            sum += ++rightIndex
            sum -= leftIndex++
        } else {
            sum -= leftIndex++
        }
    }

    writer.write("$count")
    writer.flush()
}
