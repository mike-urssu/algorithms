package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/14470
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var minutes = 0

    val currentTemperature = reader.readLine().toInt()
    val targetTemperature = reader.readLine().toInt()

    val min1 = reader.readLine().toInt()
    val min2 = reader.readLine().toInt()
    val min3 = reader.readLine().toInt()

    if (currentTemperature < 0) {
        minutes += abs(currentTemperature) * min1
        minutes += min2
        minutes += targetTemperature * min3
    } else if (currentTemperature == 0) {
        minutes += min2
        minutes += (targetTemperature) * min3
    } else {
        minutes += (targetTemperature - currentTemperature) * min3
    }

    writer.write("$minutes")
    writer.flush()
}