package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11663
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().split(" ")[1].toInt()
    val array = reader.readLine().split(" ").map { it.toInt() }.sorted()

    repeat(numberOfInput) {
        val input = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${getLowerBound(array, input[1] + 1) - getLowerBound(array, input[0])}")
        writer.newLine()
    }
    writer.flush()
}

private fun getLowerBound(array: List<Int>, number: Int): Int {
    var low = 0
    var high = array.size

    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (array[mid] >= number)
            high = mid
        else
            low = mid
    }

    return low + if (array[low] < number) 1 else 0
}