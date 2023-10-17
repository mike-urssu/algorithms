package tags.implementation

/**
 * https://www.acmicpc.net/problem/2239
 */
import kotlin.system.exitProcess

private lateinit var board: Array<IntArray>

fun main() {
    board = Array(9) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    val emptySpaces = findEmptySpaces()
    sudoku(emptySpaces, 0)
}

private fun findEmptySpaces(): List<Pair<Int, Int>> {
    val emptySpaces = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (board[i][j] == 0) {
                emptySpaces.add(Pair(i, j))
            }
        }
    }
    return emptySpaces
}

private fun sudoku(emptySpaces: List<Pair<Int, Int>>, index: Int) {
    if (index == emptySpaces.size) {
        board.forEach { println(it.joinToString("")) }
        exitProcess(0)
    }

    val (x, y) = emptySpaces[index]
    for (k in 1..9) {
        if (isRowValid(x, k) && isColValid(y, k) && isBlockValid(x, y, k)) {
            board[x][y] = k
            sudoku(emptySpaces, index + 1)
            board[x][y] = 0
        }
    }
}

private fun isRowValid(x: Int, n: Int) =
    board[x].all { it != n }

private fun isColValid(y: Int, n: Int) =
    (0 until 9).all { i -> board[i][y] != n }

private fun isBlockValid(x: Int, y: Int, n: Int): Boolean {
    val rowRange = (x / 3) * 3 until (x / 3 + 1) * 3
    val colRange = (y / 3) * 3 until (y / 3 + 1) * 3
    for (i in rowRange) {
        for (j in colRange) {
            if (board[i][j] == n) {
                return false
            }
        }
    }
    return true
}
