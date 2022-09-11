package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.min

/**
 * https://www.acmicpc.net/problem/2564
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val input = reader.readLine().split(" ").map { it.toInt() }

    val width = input[0]
    val height = input[1]
    val countOfStore = reader.readLine().toInt()
    val destinations = Array(countOfStore) { reader.readLine().split(" ").map { it.toInt() } }
    val source = reader.readLine().split(" ").map { it.toInt() }

    writer.write("${getDistance(source, destinations, width, height)}")
    writer.flush()
}

private fun getDistance(source: List<Int>, destinations: Array<List<Int>>, width: Int, height: Int): Int {
    var distance = 0

    for (destination in destinations) {
        if (source[0] == 1) {
            distance += if (destination[0] == 1) {
                abs(source[1] - destination[1])
            } else if (destination[0] == 2) {
                height + min(source[1] + destination[1], width * 2 - (source[1] + destination[1]))
            } else if (destination[0] == 3) {
                source[1] + destination[1]
            } else {
                (width - source[1]) + destination[1]
            }
        } else if (source[0] == 2) {
            distance += if (destination[0] == 1) {
                height + min(source[1] + destination[1], width * 2 - (source[1] + destination[1]))
            } else if (destination[0] == 2) {
                abs(source[1] - destination[1])
            } else if (destination[0] == 3) {
                source[1] + (height - destination[1])
            } else {
                (width - source[1]) + (height - destination[1])
            }
        } else if (source[0] == 3) {
            distance += if (destination[0] == 1) {
                source[1] + destination[1]
            } else if (destination[0] == 2) {
                (height - source[1]) + destination[1]
            } else if (destination[0] == 3) {
                abs(source[1] - destination[1])
            } else {
                width + min(source[1] + destination[1], height * 2 - (source[1] + destination[1]))
            }
        } else {
            distance += if (destination[0] == 1) {
                source[1] + (width - destination[1])
            } else if (destination[0] == 2) {
                (height - source[1]) + (width - destination[1])
            } else if (destination[0] == 3) {
                width + min(source[1] + destination[1], height * 2 - (source[1] + destination[1]))
            } else {
                abs(source[1] - destination[1])
            }
        }
    }

    return distance
}