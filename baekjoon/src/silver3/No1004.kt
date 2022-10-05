package silver3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1004
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        val src = numbers.subList(0, 2)
        val dest = numbers.subList(2, 4)

        var count = 0
        val numberOfInput = reader.readLine().toInt()
        repeat(numberOfInput) {
            val circle = reader.readLine().split(" ").map { it.toInt() }
            val point = circle.subList(0, 2)
            val radius = circle[2]

            if (isSurrounding(src, point, radius) && !isSurrounding(dest, point, radius)) {
                count++
            } else if (!isSurrounding(src, point, radius) && isSurrounding(dest, point, radius)) {
                count++
            }
        }
        writer.write("$count\n")
    }
    writer.flush()
}

private fun isSurrounding(point1: List<Int>, point2: List<Int>, radius: Int) = getDistance(point1, point2) < radius

private fun getDistance(point1: List<Int>, point2: List<Int>): Double {
    return sqrt((point2[0] - point1[0]).toDouble().pow(2) + (point2[1] - point1[1]).toDouble().pow(2))
}