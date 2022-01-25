package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/14659
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine().toInt()

    val heights = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
    writer.write(getNumberOfKilledEnemies(heights).toString())
    writer.flush()
}

fun getNumberOfKilledEnemies(heights: IntArray): Int {
    val killedEnemies = arrayListOf<Int>()
    killedEnemies.add(0)
    var index = 0

    var maxHeight = heights[0]
    for (i in 1 until heights.size) {
        if (maxHeight > heights[i])
            killedEnemies[index]++
        else {
            maxHeight = heights[i]
            killedEnemies.add(0)
            index++
        }
    }

    var maximumKilledEnemies = 0
    for (enemy in killedEnemies)
        maximumKilledEnemies = maximumKilledEnemies.coerceAtLeast(enemy)
    return maximumKilledEnemies
}
