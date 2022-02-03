package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2309
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var sum = -100
    val heights = IntArray(9)
    for (i in heights.indices) {
        val height = reader.readLine().toInt()
        heights[i] = height
        sum += height
    }
    heights.sort()

    removeTwoDwarves(heights, sum)

    for (height in heights) {
        if (height != -1) {
            writer.write(height.toString())
            writer.newLine()
        }
    }
    writer.flush()
}

fun removeTwoDwarves(heights: IntArray, sum: Int) {
    for (i in 0 until heights.size - 1) {
        for (j in i + 1 until heights.size) {
            if (heights[i] + heights[j] > sum)
                break
            else if (heights[i] + heights[j] == sum) {
                heights[i] = -1
                heights[j] = -1
                return
            }
        }
    }
}
