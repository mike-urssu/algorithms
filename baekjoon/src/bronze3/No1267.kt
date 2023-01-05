package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1267
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val seconds = reader.readLine().split(" ").map { it.toInt() }

    val cost1 = getCost(seconds, 30, 10)
    val cost2 = getCost(seconds, 60, 15)
    if (cost1 > cost2) {
        writer.write("M $cost2")
    } else if (cost1 < cost2) {
        writer.write("Y $cost1")
    } else {
        writer.write("Y M $cost1")
    }
    writer.flush()
}

fun getCost(seconds: List<Int>, timeUnit: Int, costUnit: Int): Int {
    var cost = 0
    seconds.forEach { second ->
        cost += (second + timeUnit) / timeUnit * costUnit
    }
    return cost
}
