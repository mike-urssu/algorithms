package tags.implementation

/**
 * https://www.acmicpc.net/problem/2578
 */
private lateinit var board: Array<IntArray>

fun main() {
    board = Array(5) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val numbers = mutableListOf<Int>().apply {
        repeat(5) {
            this.addAll(readln().split(" ").map { it.toInt() })
        }
    }

    for ((i, n) in numbers.withIndex()) {
        erase(n)
        if (countBingo() >= 3) {
            println(i + 1)
            return
        }
    }
}

private fun erase(n: Int) {
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (board[i][j] == n) {
                board[i][j] = -1
                return
            }
        }
    }
}

private fun countBingo(): Int {
    val rowBingo = countRowBingo()
    val colBingo = countColBingo()
    val diagonalBingo = countDiagonalBingo()
    return rowBingo + colBingo + diagonalBingo
}

private fun countRowBingo() =
    (0 until 5).count { i -> board[i].all { it == -1 } }

private fun countColBingo() =
    (0 until 5).count { j -> (0 until 5).all { i -> board[i][j] == -1 } }

private fun countDiagonalBingo(): Int {
    var count = 0
    if ((0 until 5).all { board[it][it] == -1 }) {
        count++
    }
    if ((0 until 5).all { j -> board[4 - j][j] == -1 }) {
        count++
    }
    return count
}
