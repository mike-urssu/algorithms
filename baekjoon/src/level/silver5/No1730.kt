package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1730
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var graph: Array<CharArray>
private var x = 0
private var y = 0

fun main() {
    val size = reader.readLine().toInt()
    graph = Array(size) { CharArray(size) { '.' } }

    val movements = reader.readLine().toCharArray()
    for (movement in movements) {
        move(size, y, x, movement)
    }

    for (i in 0 until size) {
        for (j in 0 until size) {
            writer.write("${graph[i][j]}")
        }
        writer.newLine()
    }
    writer.flush()
}

private fun move(size: Int, row: Int, col: Int, movement: Char) {
    when (movement) {
        'U' -> {
            if (isInBoundary(size, row - 1, col)) {
                drawHorizon(row, col)
                drawHorizon(row - 1, col)
                y--
            }
        }
        'D' -> {
            if (isInBoundary(size, row + 1, col)) {
                drawHorizon(row, col)
                drawHorizon(row + 1, col)
                y++
            }
        }
        'L' -> {
            if (isInBoundary(size, row, col - 1)) {
                drawVertical(row, col)
                drawVertical(row, col - 1)
                x--
            }
        }
        'R' -> {
            if (isInBoundary(size, row, col + 1)) {
                drawVertical(row, col)
                drawVertical(row, col + 1)
                x++
            }
        }
    }
}

private fun isInBoundary(size: Int, row: Int, col: Int) = row in 0 until size && col in 0 until size

private fun drawHorizon(row: Int, col: Int) {
    if (graph[row][col] == '.') {
        graph[row][col] = '|'
    } else if (graph[row][col] == '-') {
        graph[row][col] = '+'
    }
}

private fun drawVertical(row: Int, col: Int) {
    if (graph[row][col] == '.') {
        graph[row][col] = '-'
    } else if (graph[row][col] == '|') {
        graph[row][col] = '+'
    }
}