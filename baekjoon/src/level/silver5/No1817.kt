package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1817
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    val boxes = mutableListOf<Int>()
    if (numbers[0] != 0) {
        val maxWeight = numbers[1]
        reader.readLine().split(" ").map { it.toInt() }.forEach { weight ->
            if (boxes.isNotEmpty() && boxes.last() + weight <= maxWeight) {
                boxes[boxes.lastIndex] += weight
            } else {
                boxes.add(weight)
            }
        }
    }

    writer.write("${boxes.size}")
    writer.flush()
}