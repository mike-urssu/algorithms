package tags.backtracking

/**
 * https://www.acmicpc.net/problem/2580
 */
import kotlin.system.exitProcess

private lateinit var sudoku: Array<IntArray>
private lateinit var zeros: List<Pair<Int, Int>>

fun main() {
    sudoku = Array(9) { readln().split(" ").map { it.toInt() }.toIntArray() }
    zeros = getZeros()
    fillSudoku(0)
}

private fun getZeros(): List<Pair<Int, Int>> {
    val zeros = mutableListOf<Pair<Int, Int>>()
    (0 until 9).forEach { i ->
        (0 until 9).forEach { j ->
            if (sudoku[i][j] == 0) {
                zeros.add(Pair(i, j))
            }
        }
    }
    return zeros
}

private fun fillSudoku(index: Int) {
    if (index == zeros.size) {
        sudoku.forEach { println(it.joinToString(" ")) }
        exitProcess(0)
    }

    val (i, j) = zeros[index]
    for (k in 1..9) {
        sudoku[i][j] = k
        if (isValid(i, j)) {
            fillSudoku(index + 1)
        }
    }
    sudoku[i][j] = 0
}

private fun isValid(x: Int, y: Int) =
    isRowValid(x) && isColValid(y) && isSquareValid(x, y)

private fun isRowValid(x: Int): Boolean {
    val row = BooleanArray(10)
    for (j in 0 until 9) {
        if (sudoku[x][j] == 0) {
            continue
        }
        if (!row[sudoku[x][j]]) {
            row[sudoku[x][j]] = true
        } else {
            return false
        }
    }
    return true
}

private fun isColValid(y: Int): Boolean {
    val col = BooleanArray(10)
    for (i in 0 until 9) {
        if (sudoku[i][y] == 0) {
            continue
        }
        if (!col[sudoku[i][y]]) {
            col[sudoku[i][y]] = true
        } else {
            return false
        }
    }
    return true
}

private fun isSquareValid(x: Int, y: Int): Boolean {
    val square = BooleanArray(10)
    for (i in (x / 3) * 3 until (x / 3) * 3 + 3) {
        for (j in (y / 3) * 3 until (y / 3) * 3 + 3) {
            if (sudoku[i][j] == 0) {
                continue
            }
            if (!square[sudoku[i][j]]) {
                square[sudoku[i][j]] = true
            } else {
                return false
            }
        }
    }
    return true
}
