package level.silver3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1002
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }

        val pos1 = numbers.subList(0, 2)
        val radius1 = numbers[2]
        val pos2 = numbers.subList(3, 5)
        val radius2 = numbers[5]

        if (pos1 == pos2) {
            if (radius1 == radius2) {
                writer.write("-1")
            } else {
                writer.write("0")
            }
        } else {
            val bigRadius = radius1.coerceAtLeast(radius2).toDouble()
            val smallRadius = radius2.coerceAtMost(radius1).toDouble()
            val distance = getDistance(pos1, pos2)

            if (distance + smallRadius < bigRadius || smallRadius + bigRadius < distance) {
                writer.write("0")
            } else if (distance + smallRadius == bigRadius || smallRadius + bigRadius == distance) {
                writer.write("1")
            } else {
                writer.write("2")
            }
        }
        writer.newLine()
    }
    writer.flush()
}

private fun getDistance(pos1: List<Int>, pos2: List<Int>): Double {
    return sqrt((pos2[0] - pos1[0]).toDouble().pow(2) + (pos2[1] - pos1[1]).toDouble().pow(2))
}