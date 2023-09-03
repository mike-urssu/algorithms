package tags.bfs

/**
 * https://www.acmicpc.net/problem/16953
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    var count = -1
    val queue: Queue<Pair<Long, Int>> = LinkedList()
    queue.add(Pair(a, 1))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val c = p.second
        if (x == b) {
            count = c
            break
        }

        if (x * 2 <= b) {
            queue.add(Pair(x * 2, c + 1))
        }
        if (x * 10 + 1 <= b) {
            queue.add(Pair(x * 10 + 1, c + 1))
        }
    }

    println(count)
}
