package tags.bfs

/**
 * https://www.acmicpc.net/problem/11559
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var board: Array<CharArray>
private val colors = charArrayOf('R', 'G', 'B', 'P', 'Y')
private var chain = 0

fun main() {
    board = Array(12) { readln().toCharArray() }

    while (true) {
        var isPopped = false
        for (i in 11 downTo 0) {
            for (j in 0 until 6) {
                if (board[i][j] in colors) {
                    if (canPop(i, j, board[i][j])) {
                        pop(i, j, board[i][j])
                        isPopped = true
                    }
                }
            }
        }

        if (isPopped) {
            dropDown()
            chain++
        } else {
            break
        }
    }
    println(chain)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun canPop(x: Int, y: Int, color: Char): Boolean {
    val isVisited = Array(12) { BooleanArray(6) }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(x, y))
    isVisited[x][y] = true
    var count = 1

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until 4) {
            val nextX = p.first + dx[i]
            val nextY = p.second + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && board[nextX][nextY] == color) {
                queue.add(Pair(nextX, nextY))
                isVisited[nextX][nextY] = true
                count++
            }
        }
    }
    return count >= 4
}

private fun pop(x: Int, y: Int, color: Char) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(x, y))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        board[p.first][p.second] = '.'
        for (i in 0 until 4) {
            val nextX = p.first + dx[i]
            val nextY = p.second + dy[i]
            if (isInBoundary(nextX, nextY) && board[nextX][nextY] == color) {
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until 12 && y in 0 until 6

private fun dropDown() {
    for (j in 0 until 6) {
        var x = 11
        for (i in 11 downTo 0) {
            if (board[i][j] in colors) {
                val color = board[i][j]
                board[i][j] = '.'
                board[x--][j] = color
            }
        }
    }
}
