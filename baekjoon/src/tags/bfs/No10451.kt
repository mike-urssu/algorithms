package tags.bfs

/**
 * https://www.acmicpc.net/problem/10451
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val numbers = IntArray(n + 1).apply {
            readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
        }
        println(countCycles(n, numbers))
    }
}

private fun countCycles(n: Int, numbers: IntArray): Int {
    var cycles = 0
    val isVisited = BooleanArray(n + 1)
    (1..n).forEach { i ->
        if (!isVisited[i]) {
            val queue: Queue<Int> = LinkedList()
            queue.add(i)
            while (queue.isNotEmpty()) {
                val p = queue.poll()
                if (!isVisited[p]) {
                    isVisited[p] = true
                    queue.add(numbers[p])
                } else {
                    cycles++
                    break
                }
            }
        }
    }
    return cycles
}
