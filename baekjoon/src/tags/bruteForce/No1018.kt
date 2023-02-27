package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1018
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = Array(n) { readln().toCharArray() }

    var min = Int.MAX_VALUE
    for (i in 0 .. n - 8) {
        for (j in 0 .. m - 8) {
            val white = whiteFirst(board, i, j)
            val black = blackFirst(board, i, j)
            min = min.coerceAtMost(white.coerceAtMost(black))
        }
    }
    println(min)
}

private fun whiteFirst(board: Array<CharArray>, row: Int, col: Int): Int {
    var count = 0
    for (i in row until row + 8) {
        for (j in col until col + 8) {
            if ((i + j) % 2 == 0 && board[i][j] == 'B') {
                count++
            } else if ((i + j) % 2 == 1 && board[i][j] == 'W') {
                count++
            }
        }
    }
    return count
}

private fun blackFirst(board: Array<CharArray>, row: Int, col: Int): Int {
    var count = 0
    for (i in row until row + 8) {
        for (j in col until col + 8) {
            if ((i + j) % 2 == 0 && board[i][j] == 'W') {
                count++
            } else if ((i + j) % 2 == 1 && board[i][j] == 'B') {
                count++
            }
        }
    }
    return count
}
