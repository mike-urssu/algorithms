package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1149
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()

    val rgb = Array(numberOfInput) { IntArray(3) }
    repeat(numberOfInput) { i ->
        rgb[i] = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 1 until numberOfInput) {
        rgb[i][0] = rgb[i][0] + rgb[i - 1][1].coerceAtMost(rgb[i - 1][2])
        rgb[i][1] = rgb[i][1] + rgb[i - 1][2].coerceAtMost(rgb[i - 1][0])
        rgb[i][2] = rgb[i][2] + rgb[i - 1][0].coerceAtMost(rgb[i - 1][1])
    }

    writer.write(
        "${rgb[numberOfInput - 1][0].coerceAtMost(rgb[numberOfInput - 1][1]).coerceAtMost(rgb[numberOfInput - 1][2])}"
    )
    writer.flush()
}
