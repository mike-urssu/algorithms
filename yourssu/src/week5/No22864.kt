package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/22864
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    val stressPerHour = numbers[0]
    val workLoadPerHour = numbers[1]
    val reducedStressPerHour = numbers[2]
    val maxStress = numbers[3]

    var stress = 0
    var workload = 0
    var hourLeft = 24
    while (hourLeft-- > 0) {
        if (stress + stressPerHour <= maxStress) {
            stress += stressPerHour
            workload += workLoadPerHour
        } else {
            stress = (stress - reducedStressPerHour).coerceAtLeast(0)
        }
    }

    writer.write("$workload")
    writer.flush()
}