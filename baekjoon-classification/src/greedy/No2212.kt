package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2212
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfSensor = reader.readLine().toInt()
    val numberOfBaseStation = reader.readLine().toInt()
    val sensors = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
    sensors.sort()

    val distances = IntArray(numberOfSensor - 1)
    for (i in distances.indices)
        distances[i] = sensors[i + 1] - sensors[i]
    distances.sort()

    var distance = 0
    for (i in 0 until numberOfSensor - numberOfBaseStation)
        distance += distances[i]

    writer.write(distance.toString())
    writer.flush()
}
