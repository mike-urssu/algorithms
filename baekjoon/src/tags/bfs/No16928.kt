package tags.bfs

/**
 * https://www.acmicpc.net/problem/16928
 */
import java.util.LinkedList
import java.util.Queue

private val board = IntArray(101) { it }
private val counts = IntArray(101)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    repeat(n + m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        board[x] = y
    }
    rollDice()
    println(counts[100])
}

private fun rollDice() {
    val queue: Queue<Int> = LinkedList()
    queue.add(1)

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 1..6) {
            val nextV = p + i
            if (counts[board[nextV]] == 0) {
                queue.add(board[nextV])
                counts[board[nextV]] = counts[p] + 1
            }
            if (nextV == 100) {
                return
            }
        }
    }
}
