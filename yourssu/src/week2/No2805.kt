package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2805
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val requiredHeight = reader.readLine().split(" ").map { it.toLong() }[1]
    val heights = reader.readLine().split(" ").map { it.toLong() }
    writer.write("${getHeight(heights, requiredHeight)}")
    writer.flush()
}

private fun getHeight(heights: List<Long>, requiredHeight: Long): Int {
    var low = 0
    var high = 1000000000 + 1

    while (low + 1 < high) {
        val height = (low + high) / 2
        if (heights.sumOf { (it - height).coerceAtLeast(0) } < requiredHeight)
            high = height
        else
            low = height
    }

    return low
}