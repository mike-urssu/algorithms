package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1051
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val size = reader.readLine().split(" ").map { it.toInt() }
    val rectangle = getRectangle(size)

    var maxSize = 1
    for (i in rectangle.indices) {
        for (j in rectangle[i].indices) {
            for (k in 0 until 50) {
                if (!isInBoundary(rectangle, i + k, j + k))
                    break

                if (isJungSquare(rectangle, i, j, k))
                    maxSize = maxSize.coerceAtLeast((k + 1) * (k + 1))
            }
        }
    }

    writer.write("$maxSize")
    writer.flush()
}

private fun getRectangle(size: List<Int>): Array<IntArray> {
    return Array(size[0]) {
        val digits = reader.readLine()
        val numbers = IntArray(size[1]) { i -> digits[i].digitToInt() }
        numbers
    }
}

private fun isInBoundary(rectangle: Array<IntArray>, y: Int, x: Int): Boolean {
    return (x < rectangle[0].size) && (y < rectangle.size)
}

private fun isJungSquare(rectangle: Array<IntArray>, i: Int, j: Int, k: Int): Boolean {
    val number = rectangle[i][j]
    return number == rectangle[i + k][j]
            && number == rectangle[i][j + k]
            && number == rectangle[i + k][j + k]
}