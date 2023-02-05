package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/13305
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val cities = reader.readLine().toInt()
    val distances = reader.readLine().split(' ').map { it.toInt() }
    val costs = reader.readLine().split(' ').map { it.toInt() }

    var min = Integer.MAX_VALUE
    var cost = 0L
    for (i in 0 until cities - 1) {
        min = min.coerceAtMost(costs[i])
        cost += min.toLong() * distances[i]
    }

    writer.write(cost.toString())
    writer.flush()
}
