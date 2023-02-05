package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1996
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var map: Array<IntArray>
private val xs = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
private val ys = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)

fun main() {
    val size = reader.readLine().toInt()
    map = Array(size) { reader.readLine().map { it.code }.toIntArray() }

    for (i in 0 until size) {
        for (j in 0 until size) {
            writer.write("${getMines(size, i, j)}")
        }
        writer.newLine()
    }
    writer.flush()
}

private fun getMines(size: Int, i: Int, j: Int): Char {
    if (map[i][j] in '1'.code..'9'.code) {
        return '*'
    }

    var mines = 0
    for (index in 0 until 8) {
        val nextRow = i + ys[index]
        val nextCol = j + xs[index]
        if (isInBoundary(size, nextRow, nextCol) && map[nextRow][nextCol] in '1'.code..'9'.code) {
            mines += map[nextRow][nextCol] - '0'.code
        }
    }

    return if (mines >= 10)
        'M'
    else {
        mines.digitToChar()
    }
}

private fun isInBoundary(size: Int, row: Int, col: Int) = row in 0 until size && col in 0 until size